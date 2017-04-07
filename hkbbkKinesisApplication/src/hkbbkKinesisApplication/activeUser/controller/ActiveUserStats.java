package hkbbkKinesisApplication.activeUser.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hkbbkKinesisApplication.utils.Constants;
import hkbbkKinesisApplication.utils.JPAUtil;
import hkbbkKinesisApplication.entity.HkbbkActiveUserRecord;
import hkbbkKinesisApplication.entity.Region;
import hkbbkKinesisApplication.model.KinesisActiveUserRecord;

public class ActiveUserStats {

	private Map<java.sql.Date, HkbbkActiveUserRecord> ActiveUserLists;
	private Map<java.sql.Date, Map<String,Long>> regions;
	private static final Log LOG = LogFactory.getLog(ActiveUserStats.class);
	
    public ActiveUserStats() {
    	
    	ActiveUserLists = new HashMap<java.sql.Date, HkbbkActiveUserRecord>();
//    	regionMap = new HashMap<String,Long>();
    	regions = new HashMap<java.sql.Date, Map<String,Long>>();
    }
    
    public void addActiveUser(KinesisActiveUserRecord activeUserRecord) {
    	
//    	LOG.info("****** Starting add ActiveUser  ******\n");
    	
    	Date now = new Date();
    	
    	Date nowDay = now;
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(nowDay);
    	cal.set(Calendar.HOUR_OF_DAY, 0);
    	cal.set(Calendar.MINUTE, 0);
    	cal.set(Calendar.SECOND, 0);
    	cal.set(Calendar.MILLISECOND, 0);
    	nowDay = cal.getTime();
    	
    	java.sql.Date day = new java.sql.Date(nowDay.getTime());
    	//create or get ad in array
    	HkbbkActiveUserRecord activeUser = ActiveUserLists.get(day);
    	Map<String,Long> regionMap = regions.get(day);
    	
    	
    	// region action
    	String region = activeUserRecord.getRegion();
    	if (regionMap == null && region != "" && region != null ) {
    		
    		Map<String,Long> newRegionMap = new HashMap<String,Long>();
    		
    		//find Cht char if in region index
    		int index = java.util.Arrays.asList(Constants.regions).indexOf(region);
    		
    		//change to English char region and add in Map
    		if (index >= 0 && index < Constants.regionsEnglish.length){
    			newRegionMap.put(Constants.regionsEnglish[index], 1L);
    		
    			regions.put(day, newRegionMap);
    		}
    	} else {
    		
    		
    		
    		
    		//find Cht char if in region index
    		int index = java.util.Arrays.asList(Constants.regions).indexOf(region);
    		
    		//change to English char region and add in Map
    		if (index >= 0 && index < Constants.regionsEnglish.length){
    			Long count = regionMap.get(Constants.regionsEnglish[index]);
        		if (count == null ){
        			count = 0L;
        		}
        		
    			regionMap.put(Constants.regionsEnglish[index], ++count);
    			regions.put(day, regionMap);
    		}
    	}

    	//active user action
    	if (activeUser == null) {
    		
    		LOG.info("****** New  Day of active User  ******\n");
    		
    		HkbbkActiveUserRecord newActiveUser = new HkbbkActiveUserRecord();
    		newActiveUser.setDay(day);
    		newActiveUser.setMale(activeUserRecord.getMale());
    		newActiveUser.setFemale(activeUserRecord.getFemale());
    		
    		//child number count :
    		Long childNumber = activeUserRecord.getChildNumber();
    		String childNumberStringValue = "";
    		if (childNumber >= 4 ){
    			childNumberStringValue = "4OrMore";
    		} else {
    			childNumberStringValue = String.valueOf(activeUserRecord.getChildNumber());
    		}
    		
    		switch (childNumberStringValue) {
    		case "1":
    			newActiveUser.addChildNumber1(1L);
    			break;
    		case "2":
    			newActiveUser.addChildNumber2(1L);
    			break;
    		case "3":
    			newActiveUser.addChildNumber3(1L);
    			break;
    		case "4OrMore":
    			newActiveUser.addChildNumber4OrMore(1L);
    			break;
    		default:
    			break;
    		
    		}
    		
    		//age range count :
    		String[] ages = activeUserRecord.getAges();
    		
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
        			newActiveUser.addAge0To3(1L);
        			break;
    			case "4":case "5":case "6":case "7":case "8":
        			newActiveUser.addAge4To8(1L);
        			break;
    			case "9":case "10":case "11":
        			newActiveUser.addAge9To12(1L);
        			break;
        		case "12OrMore":
        			newActiveUser.addAge12OrMore(1L);
        			break;
        		default:
        			break;
        		
        		}
    		}
    		
    		ActiveUserLists.put(day, newActiveUser);
    		
    	} else {
    		
    		activeUser.addMale(activeUserRecord.getMale());
    		activeUser.addFemale(activeUserRecord.getFemale());
    		
    		//child number count :
    		Long childNumber = activeUserRecord.getChildNumber();
    		String childNumberStringValue = "";
    		if (childNumber >= 4 ){
    			childNumberStringValue = "4OrMore";
    		} else {
    			childNumberStringValue = String.valueOf(activeUserRecord.getChildNumber());
    		}
    		
    		switch (childNumberStringValue) {
    		case "1":
    			activeUser.addChildNumber1(1L);
    			break;
    		case "2":
    			activeUser.addChildNumber2(1L);
    			break;
    		case "3":
    			activeUser.addChildNumber3(1L);
    			break;
    		case "4OrMore":
    			activeUser.addChildNumber4OrMore(1L);
    			break;
    		default:
    			break;
    		
    		}
    		
    		//age range count :
    		String[] ages = activeUserRecord.getAges();
    		
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
    				activeUser.addAge0To3(1L);
        			break;
    			case "4":case "5":case "6":case "7":case "8":
    				activeUser.addAge4To8(1L);
        			break;
    			case "9":case "10":case "11":
    				activeUser.addAge9To12(1L);
        			break;
        		case "12OrMore":
        			activeUser.addAge12OrMore(1L);
        			break;
        		default:
        			break;
        		
        		}
    		}

    		activeUser.setUpdatedAt(now);
    		ActiveUserLists.put(day, activeUser);

    	}

    }

    
    
    public void checkAndUpdateDB(){
    	
		LOG.info("****** Region Update  ******\n");
    	regions.forEach((day,regionMap)->{

    		Region oldRegion = queryDayRegionRecord(day);
    		if (oldRegion != null){
    			
    			Map<?,?> oldRegionToMap = oldRegion.toMap();

    			oldRegionToMap.remove("day");
    			Long id = (Long) oldRegionToMap.get("id");
    			oldRegionToMap.remove("id");
    			
    			@SuppressWarnings("unchecked")
    			Map<String,Long> oldRegionMap = (Map<String, Long>)oldRegionToMap;
    			
    			// merge count 2 region map
    			Map<Object, Object> newMap = Stream.concat(regionMap.keySet().stream(), oldRegionMap.keySet().stream())
    					.distinct()
    					.collect(Collectors.toMap(k -> k, k -> regionMap.getOrDefault(k,0L) + oldRegionMap.getOrDefault(k,0L)));
    			
    			Region newRegion = Region.fromMap(newMap);
    			newRegion.setId(id);
    			newRegion.setDay(day);
    			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    			em.getTransaction().begin();
    			em.merge(newRegion);
    			em.getTransaction().commit();
    	        em.close();
    		} else {
    			
    			Region region = Region.fromMap(regionMap);
    			region.setDay(day);
    			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    			em.getTransaction().begin();
    			em.persist(region);
    			em.getTransaction().commit();
    	        em.close();

    		}
    		
    			
    	});
    	
    	LOG.info("****** ActiveUser Update  ******\n");
    	ActiveUserLists.forEach((day,hkbbkActiveUserRecord)->{
//    		java.sql.Date day = hkbbkActiveUserRecord.getDay();
    		HkbbkActiveUserRecord oldActiveUserRecord = queryDayRecord(day);
    		if (oldActiveUserRecord != null){

    			oldActiveUserRecord.addMale(hkbbkActiveUserRecord.getMale());
    			oldActiveUserRecord.addFemale(hkbbkActiveUserRecord.getFemale());
    			
    			oldActiveUserRecord.addChildNumber1(hkbbkActiveUserRecord.getChildNumber1());
    			oldActiveUserRecord.addChildNumber2(hkbbkActiveUserRecord.getChildNumber2());
    			oldActiveUserRecord.addChildNumber3(hkbbkActiveUserRecord.getChildNumber3());
    			oldActiveUserRecord.addChildNumber4OrMore(hkbbkActiveUserRecord.getChildNumber4OrMore());

    			oldActiveUserRecord.addAge0To3(hkbbkActiveUserRecord.getAge0To3());
				oldActiveUserRecord.addAge4To8(hkbbkActiveUserRecord.getAge4To8());
				oldActiveUserRecord.addAge9To12(hkbbkActiveUserRecord.getAge9To12());
    			oldActiveUserRecord.addAge12OrMore(hkbbkActiveUserRecord.getAge12OrMore());

    			Date now = new Date();
    			oldActiveUserRecord.setUpdatedAt(now);
    			
    			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    			em.getTransaction().begin();
    			em.merge(oldActiveUserRecord);
    			em.getTransaction().commit();
    	        em.close();
    		} else {
    			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    			em.getTransaction().begin();
    			em.persist(hkbbkActiveUserRecord);
    			em.getTransaction().commit();
    	        em.close();

    		}
    		
    			
    	});
    	
    }
    
    public Region queryDayRegionRecord(java.sql.Date day){
    	
    	LOG.info("******Start query Region  ******\n");
    	
    	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    	Region singleResult = null;
		em.getTransaction().begin();
		List<Region> result = em.createQuery( "FROM Region WHERE day = :day", Region.class ).setParameter("day",day).getResultList();
		if (result.size() > 0) {
			singleResult = result.get(0);
//			System.out.println(singleResult.getAdId());
		}
        em.getTransaction().commit();
        em.close();
        //System.out.println(singleResult.getAdId());
        
        return singleResult;
    }
    
    public HkbbkActiveUserRecord queryDayRecord(java.sql.Date day){
    	
    	LOG.info("******Start query HkbbkActiveUserRecord  ******\n");
    	
    	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		HkbbkActiveUserRecord singleResult = null;
		em.getTransaction().begin();
		List<HkbbkActiveUserRecord> result = em.createQuery( "FROM HkbbkActiveUserRecord WHERE day = :day", HkbbkActiveUserRecord.class ).setParameter("day",day).getResultList();
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
                "ActiveUser list : %s \n",
                printhkbbkActiveUserRecordMap(ActiveUserLists)
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
    
    public static String printhkbbkActiveUserRecordMap( Map<java.sql.Date, HkbbkActiveUserRecord> map) {
    	StringBuilder print = new StringBuilder();
    	print.append("\n ===================================== \n");
		for (Map.Entry<java.sql.Date, HkbbkActiveUserRecord> entry : map.entrySet()) {
			String string = "|  Key : " + entry.getKey() + ", Value : " + entry.getValue() + "  |\n";
			print.append(string);
		}
		print.append(" ===================================== \n");
		return print.toString();
	}
    
    
}
