package hkbbkKinesisApplication.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity  
@Table(name="hkbbk_ad_records") 
public class HkbbkAdRecord {

	private int id;
	private Date day;
	private String adId;
	private java.util.Date createdAt;
	private java.util.Date updatedAt;
	private long click;
	private long impression;
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
	
 	public HkbbkAdRecord(){
 		java.util.Date now = new java.util.Date();
		this.createdAt = now;
		this.updatedAt = this.createdAt;
		this.childNumber1 = 0;
		this.childNumber2 = 0;
		this.childNumber3 = 0;
		this.childNumber4OrMore = 0;
	}

 	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(255) UNSIGNED")
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }
  
    @Column(name = "ad_Id") 
    public String getAdId(){
    	return adId;
    }
    
    public void setAdId(String adId){
    	this.adId = adId;
    }
    
    @Column(name = "day")  
    public Date getDay() {  
        return day;  
    }  
    public void setDay(Date day) {  
        this.day = day;  
    }  
    
    @Column(name = "created_at")  
    public java.util.Date getCreatedAt() {  
        return createdAt;  
    }  
    public void setCreatedAt(java.util.Date createdAt) {  
        this.createdAt = createdAt;  
    } 
    
    @Column(name = "updated_at")  
    public java.util.Date getUpdatedAt() {  
        return updatedAt;  
    }  
    public void setUpdatedAt(java.util.Date updatedAt) {  
        this.updatedAt = updatedAt;  
    } 
	
    @Column(name = "click") 
    public Long getClick(){
    	return click;
    }
    public void setClick(Long click){
    	this.click = click;
    }
    public void addClick(Long click){
    	this.click += click;
    }
    
    @Column(name = "impression") 
    public Long getImpression(){
    	return impression;
    }
    public void setImpression(Long impression){
    	this.impression = impression;
    }
    public void addImpression(Long impression){
    	this.impression += impression;
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
    
    @Column(name = "childNumber_1") 
    public Long getChildNumber1(){
    	return childNumber1;
    }
    public void setChildNumber1(Long childNumber1){
    	this.childNumber1 = childNumber1;
    }
    public void addChildNumber1(Long childNumber1){
    	this.childNumber1 += childNumber1;
    }
    
    @Column(name = "childNumber_2") 
    public Long getChildNumber2(){
    	return childNumber2;
    }
    public void setChildNumber2(Long childNumber2){
    	this.childNumber2 = childNumber2;
    }
    public void addChildNumber2(Long childNumber2){
    	this.childNumber2 += childNumber2;
    }
    
    @Column(name = "childNumber_3") 
    public Long getChildNumber3(){
    	return childNumber3;
    }
    public void setChildNumber3(Long childNumber3){
    	this.childNumber3 = childNumber3;
    }
    public void addChildNumber3(Long childNumber3){
    	this.childNumber3 += childNumber3;
    }
    
    @Column(name = "childNumber_4_or_more") 
    public Long getChildNumber4OrMore(){
    	return childNumber4OrMore;
    }
    public void setChildNumber4OrMore(Long childNumber4OrMore){
    	this.childNumber4OrMore = childNumber4OrMore;
    }
    public void addChildNumber4OrMore(Long childNumber4OrMore){
    	this.childNumber4OrMore += childNumber4OrMore;
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
    
    

    @Override
    public String toString() {

    	return String.format(" click %d, page view %d . ", click, impression);
    }
    
    
}
