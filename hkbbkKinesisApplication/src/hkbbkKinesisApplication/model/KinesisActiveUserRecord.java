package hkbbkKinesisApplication.model;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KinesisActiveUserRecord {
	
	private final static ObjectMapper JSON = new ObjectMapper();
    static {
        JSON.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    
    public byte[] toJsonAsBytes() {
        try {
            return JSON.writeValueAsBytes(this);
        } catch (IOException e) {
            return null;
        }
    }
    
    public static KinesisActiveUserRecord fromJsonAsMap(Map<?,?> map) {
    	
        //        	System.out.println(JSON.readValue(bytes, KinesisAdRecord.class));
		return JSON.convertValue(map, KinesisActiveUserRecord.class);
    }


    public static KinesisActiveUserRecord fromJsonAsBytes(byte[] bytes) {
    	
        try {
//        	System.out.println(JSON.readValue(bytes, KinesisAdRecord.class));
            return JSON.readValue(bytes, KinesisActiveUserRecord.class);
        } catch (IOException e) {
            return null;
        }
    }

    private String userId;
	private String region;
	private long childNumber;
	private long male;
	private long female;
	private String[] ages;
	
	
	public KinesisActiveUserRecord(){
	}
	
	public KinesisActiveUserRecord(String userId, String region, Long male, Long female, String[] ages, Long childNumber){
		
		this.userId = userId;
		this.region = region;
		this.male = (male != null) ? male :  0;
		this.female = (female != null) ? female :  0;
		this.ages = ages;
		this.childNumber = (childNumber != null) ? childNumber :  0;

	}
	
	public String getUserId(){
		return userId;
	}

	public String getRegion(){
		return region;
	}
	
	public Long getMale(){
		return male;
	}
	
	public Long getFemale(){
		return female;
	}
	
	public String[] getAges(){
		return ages;
	}
	
	public Long getChildNumber(){
		return childNumber;
	}
	

    @Override
    public String toString() {

    	return String.format("User %s: , form region %s . ", userId, region);
    }
    
	


}
