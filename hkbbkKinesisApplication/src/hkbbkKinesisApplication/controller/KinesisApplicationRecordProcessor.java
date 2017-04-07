package hkbbkKinesisApplication.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.json.JSONArray;

import com.amazonaws.services.kinesis.clientlibrary.exceptions.InvalidStateException;
import com.amazonaws.services.kinesis.clientlibrary.exceptions.ShutdownException;
import com.amazonaws.services.kinesis.clientlibrary.exceptions.ThrottlingException;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessor;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessorCheckpointer;
import com.amazonaws.services.kinesis.clientlibrary.types.ShutdownReason;
import com.amazonaws.services.kinesis.model.Record;

//import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import hkbbkKinesisApplication.activeUser.controller.ActiveUserStats;
import hkbbkKinesisApplication.ad.controller.AdStats;
import hkbbkKinesisApplication.model.KinesisActiveUserRecord;
import hkbbkKinesisApplication.model.KinesisAdRecord;
import hkbbkKinesisApplication.utils.Constants;

public class KinesisApplicationRecordProcessor implements IRecordProcessor {

	
	private static final Log LOG = LogFactory.getLog(KinesisApplicationRecordProcessor.class);
	private String kinesisShardId;
	
	public long nextCheckpointTimeInMillis;
	public long nextReportingTimeInMillis;
	
	private AdStats adStats = new AdStats();
	private ActiveUserStats activeUserStats = new ActiveUserStats();

	@Override
	public void initialize(String shardId) {
		// TODO Auto-generated method stub
        LOG.info("Initializing record processor for shard: " + shardId);
        this.kinesisShardId = shardId;
        nextReportingTimeInMillis = System.currentTimeMillis() + Constants.REPORTING_INTERVAL_MILLIS;
        nextCheckpointTimeInMillis = System.currentTimeMillis() + Constants.CHECKPOINT_INTERVAL_MILLIS;
	}

	@Override
	public void processRecords(List<Record> records, IRecordProcessorCheckpointer checkpointer) {
		// TODO Auto-generated method stub
		for (Record record : records) {
            // process record
            processRecord(record);
        }

        // If it is time to report stats as per the reporting interval, report stats
        if (System.currentTimeMillis() > nextReportingTimeInMillis) {
            reportStats();
            reset();
            checkpoint(checkpointer);
            nextReportingTimeInMillis = System.currentTimeMillis() + Constants.REPORTING_INTERVAL_MILLIS;
        }

//        // Checkpoint once every checkpoint interval
//        if (System.currentTimeMillis() > nextCheckpointTimeInMillis) {
            //checkpoint(checkpointer);
            
//            nextCheckpointTimeInMillis = System.currentTimeMillis() + Constants.CHECKPOINT_INTERVAL_MILLIS;
//        }
		
	}
	private void processRecord(Record record) {
		// TODO: Implement method
		Map<?, ?> map ;
		try {
//        	System.out.println(JSON.readValue(bytes, KinesisAdRecord.class));
			ObjectMapper JSON = new ObjectMapper();
			
			map = JSON.readValue(record.getData().array(), Map.class);
       } catch (IOException e) {
    	   map =  null;
       }
		
		Map<?, ?> ad = (Map<?, ?>) map.get("kinesisAdRecord");
		Map<?, ?> user = (Map<?, ?>) map.get("kinesisActiveUserRecord");
		
		if( ad != null ){
			KinesisAdRecord kinesisAdRecord = KinesisAdRecord.fromJsonAsMap(ad);
			adStats.addAd(kinesisAdRecord);
//			System.out.println(kinesisAdRecord);
		} else if ( user != null ){
			KinesisActiveUserRecord kinesisActiveUserRecord = KinesisActiveUserRecord.fromJsonAsMap(user);
			activeUserStats.addActiveUser(kinesisActiveUserRecord);
//			System.out.println(kinesisActiveUserRecord);
		}
//		System.out.println(map);

	}

	private void reportStats(){
        // TODO: Implement method
		adStats.checkAndUpdateDB();
    	LOG.info("****** Shard " + kinesisShardId + " stats  ******\n" +
                adStats + "\n" +
                "****************************************************************\n");
    	
    	activeUserStats.checkAndUpdateDB();
    	LOG.info("****** Shard " + kinesisShardId + " stats  ******\n" +
    			activeUserStats + "\n" +
                "****************************************************************\n");
	}
	
	private void reset(){
		adStats = new AdStats();
		activeUserStats = new ActiveUserStats();
	}
	
	
	/**
     * {@inheritDoc}
     */
    @Override
    public void shutdown(IRecordProcessorCheckpointer checkpointer, ShutdownReason reason) {
        LOG.info("Shutting down record processor for shard: " + kinesisShardId);
        // Important to checkpoint after reaching end of shard, so we can start processing data from child shards.
        if (reason == ShutdownReason.TERMINATE) {
            checkpoint(checkpointer);
        }
    }

    private void checkpoint(IRecordProcessorCheckpointer checkpointer) {
        LOG.info("Checkpointing shard " + kinesisShardId);
        try {
            checkpointer.checkpoint();
        } catch (ShutdownException se) {
            // Ignore checkpoint if the processor instance has been shutdown (fail over).
            LOG.info("Caught shutdown exception, skipping checkpoint.", se);
        } catch (ThrottlingException e) {
            // Skip checkpoint when throttled. In practice, consider a backoff and retry policy.
            LOG.error("Caught throttling exception, skipping checkpoint.", e);
        } catch (InvalidStateException e) {
            // This indicates an issue with the DynamoDB table (check for table, provisioned IOPS).
            LOG.error("Cannot save checkpoint to the DynamoDB table used by the Amazon Kinesis Client Library.", e);
        }
    }

}
