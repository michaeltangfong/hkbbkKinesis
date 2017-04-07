package hkbbkKinesisApplication.entity;

import java.util.Date;
import javax.persistence.*;

@Entity  
@Table(name="hkbbk_active_user_records") 
public class HkbbkActiveUserRecord {

	private long id;
	private java.sql.Date day;
	private String userId;
	private Date createdAt;
	private Date updatedAt;
	private long male;
	private long female;
	private long childNumber1;
	private long childNumber2;
	private long childNumber3;
	private long childNumber4OrMore;
	private long age0To3;
	private long age4To8;
	private long age9To12;
	private long age12OrMore;
//	private Map<Integer,State> region;

 	public HkbbkActiveUserRecord(){
		this.createdAt = new Date();
		this.updatedAt = this.createdAt;
		this.childNumber1 = 0;
		this.childNumber2 = 0;
		this.childNumber3 = 0;
		this.childNumber4OrMore = 0;
	}

 	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(255) UNSIGNED") 
    public long getId() {  
        return id;  
    }  
    public void setId(long id) {  
        this.id = id;  
    }
  
    @Column(name = "user_id") 
    public String getUserId(){
    	return userId;
    }
    
    public void setUserId(String userId){
    	this.userId = userId;
    }
    
    @Column(name = "day")  
    public java.sql.Date getDay() {  
        return day;  
    }  
    public void setDay(java.sql.Date day) {  
        this.day = day;  
    }  
    
    @Column(name = "created_at")  
    public Date getCreatedAt() {  
        return createdAt;  
    }  
    public void setCreatedAt(Date createdAt) {  
        this.createdAt = createdAt;  
    } 
    
    @Column(name = "updated_at")  
    public Date getUpdatedAt() {  
        return updatedAt;  
    }  
    public void setUpdatedAt(Date updatedAt) {  
        this.updatedAt = updatedAt;  
    } 
	
    @Column(name = "male") 
    public Long getMale(){
    	return male;
    }
    public void setMale(Long male){
    	this.male = male;
    }
    public void addMale(Long male){
    	this.male += male;
    }
    
    @Column(name = "female") 
    public Long getFemale(){
    	return female;
    }
    public void setFemale(Long female){
    	this.female = female;
    }
    public void addFemale(Long female){
    	this.female += female;
    }
    
    @Column(name = "child_number_1") 
    public Long getChildNumber1(){
    	return childNumber1;
    }
    public void setChildNumber1(Long childNumber1){
    	this.childNumber1 = childNumber1;
    }
    public void addChildNumber1(Long childNumber1){
    	this.childNumber1 += childNumber1;
    }
    
    @Column(name = "child_number_2") 
    public Long getChildNumber2(){
    	return childNumber2;
    }
    public void setChildNumber2(Long childNumber2){
    	this.childNumber2 = childNumber2;
    }
    public void addChildNumber2(Long childNumber2){
    	this.childNumber2 += childNumber2;
    }
    
    @Column(name = "child_number_3") 
    public Long getChildNumber3(){
    	return childNumber3;
    }
    public void setChildNumber3(Long childNumber3){
    	this.childNumber3 = childNumber3;
    }
    public void addChildNumber3(Long childNumber3){
    	this.childNumber3 += childNumber3;
    }
    
    @Column(name = "child_number_4_or_more") 
    public Long getChildNumber4OrMore(){
    	return childNumber4OrMore;
    }
    public void setChildNumber4OrMore(Long childNumber4OrMore){
    	this.childNumber4OrMore = childNumber4OrMore;
    }
    public void addChildNumber4OrMore(Long childNumber4OrMore){
    	this.childNumber4OrMore += childNumber4OrMore;
    }
    
//    @OneToOne(cascade=CascadeType.ALL)  
//    @JoinColumn(name="region_id")  
//    public Region getRegion()  
//    {  
//        return region;  
//    }  
//    public void setRegion(Region region)  
//    {  
//        this.region = region;  
//    }  

   
//    public void addRegion(String region){
//    	Long count = regions.get(region);
//    	if (count == null){
//    		count = 0L;
//    	}
//    	regions.put(region, ++count);
//    }
//    public void pushRegionMap(Map<String, Long>regions){
//    	this.regions = regions;
//    }
//    public Map<String, Long> pullRegionMap(){
//    	return this.regions;
//    }
//    public void regionToJsonString(){
//    	Gson gson = new Gson();
//    	String jsonString = gson.toJson(regions);
//    	
//    	this.regionRate = jsonString;
//
//    }
//    public Map<String, Long> jsonStringToRegionMap(){
//    	
//    	Gson gson = new Gson();
//    	Type mapType = new TypeToken<Map<String, Long>>(){
//
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;}.getType();
//    	this.regions = gson.fromJson(regionRate, mapType);
//
//    	return this.regions;
//    }
    
    @Override
    public String toString() {

    	return String.format(" Day: %s, male: %d, female: %d . ", day, male, female);
    }

    @Column(name = "age_0_to_3") 
	public long getAge0To3() {
		return age0To3;
	}

    public void setAge0To3(long age0To3) {
		this.age0To3 = age0To3;
	}
    
    public void addAge0To3(long age0To3) {
		this.age0To3 += age0To3;
	}

	@Column(name = "age_4_to_8") 
	public long getAge4To8() {
		return age4To8;
	}

	public void setAge4To8(long age4To8) {
		this.age4To8 = age4To8;
	}
	
	public void addAge4To8(long age4To8) {
		this.age4To8 += age4To8;
	}

	@Column(name = "age_9_to_12") 
	public long getAge9To12() {
		return age9To12;
	}

	public void setAge9To12(long age9To12) {
		this.age9To12 = age9To12;
	}
	
	public void addAge9To12(long age9To12) {
		this.age9To12 += age9To12;
	}

	@Column(name = "age_12_or_more") 
	public long getAge12OrMore() {
		return age12OrMore;
	}

	public void setAge12OrMore(long age12OrMore) {
		this.age12OrMore = age12OrMore;
	}
	
	public void addAge12OrMore(long age12OrMore) {
		this.age12OrMore += age12OrMore;
	}
}
