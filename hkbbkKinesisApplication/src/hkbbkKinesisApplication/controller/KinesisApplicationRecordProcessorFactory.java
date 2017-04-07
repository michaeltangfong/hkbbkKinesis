package hkbbkKinesisApplication.controller;

import com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessor;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessorFactory;

public class KinesisApplicationRecordProcessorFactory implements IRecordProcessorFactory {
    /**
     * {@inheritDoc}
     */
    @Override
    public IRecordProcessor createProcessor() {
        return new KinesisApplicationRecordProcessor();
    }
    
    public KinesisApplicationRecordProcessorFactory(){
    	super();
    }
}

