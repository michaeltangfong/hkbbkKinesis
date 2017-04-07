package hkbbkKinesisApplication.model;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KinesisAdRecord {
	
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

    public static KinesisAdRecord fromJsonAsBytes(byte[] bytes) {
    	
        try {
//        	System.out.println(JSON.readValue(bytes, KinesisAdRecord.class));
            return JSON.readValue(bytes, KinesisAdRecord.class);
        } catch (IOException e) {
            return null;
        }
    }
    
    public static KinesisAdRecord fromJsonAsMap(Map<?,?> map) {
    	
        //        	System.out.println(JSON.readValue(bytes, KinesisAdRecord.class));
		return JSON.convertValue(map, KinesisAdRecord.class);
    }

    private String adId;
    private long click;
    private long impression;
	private String region;
	private long childNumber;
	private long male;
	private long female;
	private String[] ages;
	
	
	public KinesisAdRecord(){
	}
	
	public KinesisAdRecord(String adId, Long click, Long impression, String region, Long male, Long female, String[] ages, Long childNumber){
		
		this.adId = adId;
		this.click = (click != null) ? click :  0;
		this.impression = impression;
		this.region = region;
		this.male = (male != null) ? male :  0;
		this.female = (female != null) ? female :  0;
		this.ages = ages;
		this.childNumber = (childNumber != null) ? childNumber :  0;

	}
	
	public String getAdId(){
		return adId;
	}

	public Long getClick(){
		return click;
	}
	
	public Long getImpression(){
		return impression;
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

    	return String.format("Ad %s: , click %d, page view %d, form region %s . ", adId, click, impression, region);
    }
    
	


}
