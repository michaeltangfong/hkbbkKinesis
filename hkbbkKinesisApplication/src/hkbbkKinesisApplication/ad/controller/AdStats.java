package hkbbkKinesisApplication.ad.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import hkbbkKinesisApplication.utils.JPAUtil;
import hkbbkKinesisApplication.entity.HkbbkAdRecord;
import hkbbkKinesisApplication.model.KinesisAdRecord;




public class AdStats {
	
    private Map<String, HkbbkAdRecord> AdLists;
    public AdStats() {
    	
    	AdLists = new HashMap<String, HkbbkAdRecord>();
    }
    
    public void addAd(KinesisAdRecord adRecord) {
    	//create or get ad in array
    	String adId = adRecord.getAdId();
    	HkbbkAdRecord ad = AdLists.get(adId);
    	if (ad == null) {
    		HkbbkAdRecord newHkbbkAdRecord = new HkbbkAdRecord();
    		Date now = new Date();
    		java.sql.Date day = new java.sql.Date(now.getTime());
    		newHkbbkAdRecord.setDay(day);
    		newHkbbkAdRecord.setAdId(adId);
    		newHkbbkAdRecord.setClick(adRecord.getClick());
    		newHkbbkAdRecord.setImpression(adRecord.getImpression());
    		newHkbbkAdRecord.setMale(adRecord.getMale());
    		newHkbbkAdRecord.setFemale(adRecord.getFemale());
    		
    		//child number count :
    		Long childNumber = adRecord.getChildNumber();
    		String childNumberStringValue = "";
    		if (childNumber >= 4 ){
    			childNumberStringValue = "4OrMore";
    		} else {
    			childNumberStringValue = String.valueOf(adRecord.getChildNumber());
    		}
    		
    		switch (childNumberStringValue) {
    		case "1":
    			newHkbbkAdRecord.addChildNumber1(1L);
    			break;
    		case "2":
    			newHkbbkAdRecord.addChildNumber2(1L);
    			break;
    		case "3":
    			newHkbbkAdRecord.addChildNumber3(1L);
    			break;
    		case "4OrMore":
    			newHkbbkAdRecord.addChildNumber4OrMore(1L);
    			break;
    		default:
    			break;
    		
    		}
    		
    		//age range count :
    		String[] ages = adRecord.getAges();
    		
    		String ageStringValue = "";
    		
    		for (String age : ages){
    			int year = Integer.parseInt(age);
    			int nowYear = Calendar.getInstance().get(Calendar.YEAR);
    			
    			int ageRange = nowYear - year;
    			if (ageRange >= 12) {
    				ageStringValue = "12OrMore";
    			} else {
    				ageStringValue =  String.valueOf(ageRange);
    			}

    			switch (ageStringValue) {
    			case "0":case "1":case "2":case "3":
    				newHkbbkAdRecord.addAge0To3(1L);
        			break;
    			case "4":case "5":case "6":case "7":case "8":
    				newHkbbkAdRecord.addAge4To8(1L);
        			break;
    			case "9":case "10":case "11":
    				newHkbbkAdRecord.addAge9To12(1L);
        			break;
        		case "12OrMore":
        			newHkbbkAdRecord.addAge12OrMore(1L);
        			break;
        		default:
        			break;
        		
        		}
    		}
    		
    		
    		AdLists.put(adId, newHkbbkAdRecord);
    		
    	} else {
    		
    		ad.addClick(adRecord.getClick());
    		ad.addImpression(adRecord.getImpression());
    		ad.addMale(adRecord.getMale());
    		ad.addFemale(adRecord.getFemale());
    		
    		//child number count :
    		Long childNumber = adRecord.getChildNumber();
    		String childNumberStringValue = "";
    		if (childNumber >= 4 ){
    			childNumberStringValue = "4OrMore";
    		} else {
    			childNumberStringValue = String.valueOf(adRecord.getChildNumber());
    		}
    		
    		switch (childNumberStringValue) {
    		case "1":
    			ad.addChildNumber1(1L);
    			break;
    		case "2":
    			ad.addChildNumber2(1L);
    			break;
    		case "3":
    			ad.addChildNumber3(1L);
    			break;
    		case "4OrMore":
    			ad.addChildNumber4OrMore(1L);
    			break;
    		default:
    			break;
    		
    		}
    		
    		//age range count :
    		String[] ages = adRecord.getAges();
    		
    		String ageStringValue = "";
    		
    		for (String age : ages){
    			int year = Integer.parseInt(age);
    			int nowYear = Calendar.getInstance().get(Calendar.YEAR);
    			
    			int ageRange = nowYear - year;
    			if (ageRange >= 12) {
    				ageStringValue = "12OrMore";
    			} else {
    				ageStringValue =  String.valueOf(ageRange);
    			}

    			switch (ageStringValue) {
    			case "0":case "1":case "2":case "3":
    				ad.addAge0To3(1L);
        			break;
    			case "4":case "5":case "6":case "7":case "8":
    				ad.addAge4To8(1L);
        			break;
    			case "9":case "10":case "11":
    				ad.addAge9To12(1L);
        			break;
        		case "12OrMore":
        			ad.addAge12OrMore(1L);
        			break;
        		default:
        			break;
        		
        		}
    		}
    		
    		
    		Date now = new Date();
    		ad.setUpdatedAt(now);

    	}

    }

    public void checkAndUpdateDB(){
    	AdLists.forEach((adId,hkbbkAdRecord)->{
    		java.sql.Date day = hkbbkAdRecord.getDay();
    		HkbbkAdRecord oldAdrecord = queryDayRecord(adId, day);
    		if (oldAdrecord != null){

    			oldAdrecord.addClick(hkbbkAdRecord.getClick());
    			oldAdrecord.addImpression(hkbbkAdRecord.getImpression());
    			oldAdrecord.addMale(hkbbkAdRecord.getMale());
    			
    			oldAdrecord.addChildNumber1(hkbbkAdRecord.getChildNumber1());
    			oldAdrecord.addChildNumber2(hkbbkAdRecord.getChildNumber2());
    			oldAdrecord.addChildNumber3(hkbbkAdRecord.getChildNumber3());
    			oldAdrecord.addChildNumber4OrMore(hkbbkAdRecord.getChildNumber4OrMore());
    			
    			oldAdrecord.addAge0To3(hkbbkAdRecord.getAge0To3());
    			oldAdrecord.addAge4To8(hkbbkAdRecord.getAge4To8());
    			oldAdrecord.addAge9To12(hkbbkAdRecord.getAge9To12());
    			oldAdrecord.addAge12OrMore(hkbbkAdRecord.getAge12OrMore());
    			
    			oldAdrecord.addFemale(hkbbkAdRecord.getFemale());
    			Date now = new Date();
    			oldAdrecord.setUpdatedAt(now);
    			
    			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    			em.getTransaction().begin();
    			em.merge(oldAdrecord);
    			em.getTransaction().commit();
    	        em.close();
    		} else {
    			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    			em.getTransaction().begin();
    			em.persist(hkbbkAdRecord);
    			em.getTransaction().commit();
    	        em.close();

    		}
    		
    			
    	});
    }
    
    public HkbbkAdRecord queryDayRecord(String adId,java.sql.Date day){
    	
    	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		HkbbkAdRecord singleResult = null;
		em.getTransaction().begin();
		List<HkbbkAdRecord> result = em.createQuery( "FROM HkbbkAdRecord WHERE adId = :id AND day = :day", HkbbkAdRecord.class ).setParameter("id",adId).setParameter("day",day).getResultList();
		if (result.size() > 0) {
			singleResult = result.get(0);
//			System.out.println(singleResult.getAdId());
		}
        em.getTransaction().commit();
        em.close();
        //System.out.println(singleResult.getAdId());
        
        return singleResult;
    }

    public String toString() {
        return String.format(
                "Ad list : %s \n",
                printHkbbkAdRecordMap(AdLists)
        		);
    }

    public static String printMap(Map<String, Long> map) {
    	StringBuilder print = new StringBuilder();
    	print.append("\n ===================================== \n");
		for (Map.Entry<String, Long> entry : map.entrySet()) {
			String string = "|  Key : " + entry.getKey() + ", Value : " + entry.getValue() + "  |\n";
			print.append(string);
		}
		print.append(" ===================================== \n");
		return print.toString();
	}
    
    public static String printHkbbkAdRecordMap(Map<String, HkbbkAdRecord> map) {
    	StringBuilder print = new StringBuilder();
    	print.append("\n ===================================== \n");
		for (Map.Entry<String, HkbbkAdRecord> entry : map.entrySet()) {
			String string = "|  Key : " + entry.getKey() + ", Value : " + entry.getValue() + "  |\n";
			print.append(string);
		}
		print.append(" ===================================== \n");
		return print.toString();
	}

}
