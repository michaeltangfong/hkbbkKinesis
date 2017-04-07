package hkbbkKinesisApplication.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.ObjectMapper;


@Entity  
@Table(name="region") 
public class Region {

	private long id;
	private java.sql.Date day;
	private long SheungWan;
	private long TinHang ;
	private long ThePeak;
	private long Central;
	private long Soho;
	private long LanKwaiFong ;
	private long TinHau;
	private long TaiKoo ;
	private long NorthPolong ;
	private long MidLevels;
	private long ShekO;
	private long WesternDistrict;
	private long Stanley ; 
	private long Admiralty; 
	private long ChaiWan; 
	private long WanChai; 
	private long SaiWanHo; 
	private long HengFaChuen; 
	private long Aberdeen; 
	private long RepulseBay; 
	private long DeepWaterbay; 
	private long HappyValley; 
	private long ShauKeiWan;
	private long CausewayBay; 
	private long ApLeiChau; 
	private long PokFuLam; 
	private long Cyberport; 
	private long QuarryBay; 
	private long PrinceEdward; 
	private long Jordan; 
	private long MongKok; 
	private long YauTong; 
	private long HungHom; 
	private long MeiFoo; 
	private long ChoiHung;
	private long LokFu; 
	private long LamTin; 
	private long KwunTong; 
	private long KowloonCity; 
	private long KowloonTong; 
	private long KowloonBay; 
	private long ToKwaWan; 
	private long TaiKokTsui;
	private long NgauTauKwok;
	private long ShekKipMei;
	private long TsimShaTsui;
	private long KnutsfordTerrace;
	private long HoManTin; 
	private long YauMaTei; 
	private long CheungShaWan; 
	private long LaiChiKok; 
	private long ShamShuiPo; 
	private long WongTaiSin; 
	private long TszWanShan; 
	private long SanPoKong; 
	private long LeiYueMun; 
	private long DiamondHill; 
	private long SheungShui; 
	private long TaiPo;
	private long TaiWai; 
	private long YuenLong; 
	private long TaiWo; 
	private long TuenMun; 
	private long FoTan; 
	private long SaiKung;
	private long ShaTin; 
	private long TsingYi; 
	private long Fanling; 
	private long TsuenWan; 
	private long MaWan; 
	private long ShamTseng; 
	private long KwaiFong; 
	private long KwaiChung; 
	private long LoWu;
	private long TinShuiWai; 
	private long LauFaushan; 
	private long MaOnShan; 
	private long TseungKwanO; 
	private long LokMaChau; 
	private long TaiO; 
	private long PingChau; 
	private long TungChung; 
	private long CheungChau; 
	private long LantauIsland; 
	private long ChekLapKok; 
	private long LammaIsland; 
	private long DiscoveryBay; 
	private long PoToiIsland;
	private final static ObjectMapper JSON = new ObjectMapper();
	
    public static Region fromMap(Map<?,?> map) {
    
        //        	System.out.println(JSON.readValue(bytes, KinesisAdRecord.class));
		return JSON.convertValue(map, Region.class);
    }
    
    public Map<?, ?> toMap(){
    	 return JSON.convertValue(this, Map.class);
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
	
	@Column(name = "day")  
    public java.sql.Date getDay() {  
        return day;  
    }  
    public void setDay(java.sql.Date day) {  
        this.day = day;  
    }  
	
	public long getSheungWan() {
		return SheungWan;
	}
	public void setSheungWan(long sheungWan) {
		SheungWan = sheungWan;
	}
	public long getTinHau() {
		return TinHau;
	}
	public void setTinHau(long tinHau) {
		TinHau = tinHau;
	}
	public long getTinHang() {
		return TinHang;
	}
	public void setTinHang(long tinHang) {
		TinHang = tinHang;
	}
	public long getThePeak() {
		return ThePeak;
	}
	public void setThePeak(long thePeak) {
		ThePeak = thePeak;
	}
	public long getCentral() {
		return Central;
	}
	public void setCentral(long central) {
		Central = central;
	}
	public long getSoho() {
		return Soho;
	}
	public void setSoho(long soho) {
		Soho = soho;
	}
	public long getLanKwaiFong() {
		return LanKwaiFong;
	}
	public void setLanKwaiFong(long lanKwaiFong) {
		LanKwaiFong = lanKwaiFong;
	}
	public long getTaiKoo() {
		return TaiKoo;
	}
	public void setTaiKoo(long taiKoo) {
		TaiKoo = taiKoo;
	}
	public long getNorthPolong() {
		return NorthPolong;
	}
	public void setNorthPolong(long northPolong) {
		NorthPolong = northPolong;
	}
	public long getMidLevels() {
		return MidLevels;
	}
	public void setMidLevels(long midLevels) {
		MidLevels = midLevels;
	}
	public long getShekO() {
		return ShekO;
	}
	public void setShekO(long shekO) {
		ShekO = shekO;
	}
	public long getWesternDistrict() {
		return WesternDistrict;
	}
	public void setWesternDistrict(long westernDistrict) {
		WesternDistrict = westernDistrict;
	}
	public long getStanley() {
		return Stanley;
	}
	public void setStanley(long stanley) {
		Stanley = stanley;
	}
	public long getAdmiralty() {
		return Admiralty;
	}
	public void setAdmiralty(long admiralty) {
		Admiralty = admiralty;
	}
	public long getChaiWan() {
		return ChaiWan;
	}
	public void setChaiWan(long chaiWan) {
		ChaiWan = chaiWan;
	}
	public long getWanChai() {
		return WanChai;
	}
	public void setWanChai(long wanChai) {
		WanChai = wanChai;
	}
	public long getSaiWanHo() {
		return SaiWanHo;
	}
	public void setSaiWanHo(long saiWanHo) {
		SaiWanHo = saiWanHo;
	}
	public long getHengFaChuen() {
		return HengFaChuen;
	}
	public void setHengFaChuen(long hengFaChuen) {
		HengFaChuen = hengFaChuen;
	}
	public long getAberdeen() {
		return Aberdeen;
	}
	public void setAberdeen(long aberdeen) {
		Aberdeen = aberdeen;
	}
	public long getRepulseBay() {
		return RepulseBay;
	}
	public void setRepulseBay(long repulseBay) {
		RepulseBay = repulseBay;
	}
	public long getDeepWaterbay() {
		return DeepWaterbay;
	}
	public void setDeepWaterbay(long deepWaterbay) {
		DeepWaterbay = deepWaterbay;
	}
	public long getHappyValley() {
		return HappyValley;
	}
	public void setHappyValley(long happyValley) {
		HappyValley = happyValley;
	}
	public long getShauKeiWan() {
		return ShauKeiWan;
	}
	public void setShauKeiWan(long shauKeiWan) {
		ShauKeiWan = shauKeiWan;
	}
	public long getCausewayBay() {
		return CausewayBay;
	}
	public void setCausewayBay(long causewayBay) {
		CausewayBay = causewayBay;
	}
	public long getApLeiChau() {
		return ApLeiChau;
	}
	public void setApLeiChau(long apLeiChau) {
		ApLeiChau = apLeiChau;
	}
	public long getPokFuLam() {
		return PokFuLam;
	}
	public void setPokFuLam(long pokFuLam) {
		PokFuLam = pokFuLam;
	}
	public long getCyberport() {
		return Cyberport;
	}
	public void setCyberport(long cyberport) {
		Cyberport = cyberport;
	}
	public long getQuarryBay() {
		return QuarryBay;
	}
	public void setQuarryBay(long quarryBay) {
		QuarryBay = quarryBay;
	}
	public long getPrinceEdward() {
		return PrinceEdward;
	}
	public void setPrinceEdward(long princeEdward) {
		PrinceEdward = princeEdward;
	}
	public long getJordan() {
		return Jordan;
	}
	public void setJordan(long jordan) {
		Jordan = jordan;
	}
	public long getMongKok() {
		return MongKok;
	}
	public void setMongKok(long mongKok) {
		MongKok = mongKok;
	}
	public long getYauTong() {
		return YauTong;
	}
	public void setYauTong(long yauTong) {
		YauTong = yauTong;
	}
	public long getHungHom() {
		return HungHom;
	}
	public void setHungHom(long hungHom) {
		HungHom = hungHom;
	}
	public long getMeiFoo() {
		return MeiFoo;
	}
	public void setMeiFoo(long meiFoo) {
		MeiFoo = meiFoo;
	}
	public long getChoiHung() {
		return ChoiHung;
	}
	public void setChoiHung(long choiHung) {
		ChoiHung = choiHung;
	}
	public long getLokFu() {
		return LokFu;
	}
	public void setLokFu(long lokFu) {
		LokFu = lokFu;
	}
	public long getLamTin() {
		return LamTin;
	}
	public void setLamTin(long lamTin) {
		LamTin = lamTin;
	}
	public long getKwunTong() {
		return KwunTong;
	}
	public void setKwunTong(long kwunTong) {
		KwunTong = kwunTong;
	}
	public long getKowloonCity() {
		return KowloonCity;
	}
	public void setKowloonCity(long kowloonCity) {
		KowloonCity = kowloonCity;
	}
	public long getKowloonTong() {
		return KowloonTong;
	}
	public void setKowloonTong(long kowloonTong) {
		KowloonTong = kowloonTong;
	}
	public long getKowloonBay() {
		return KowloonBay;
	}
	public void setKowloonBay(long kowloonBay) {
		KowloonBay = kowloonBay;
	}
	public long getToKwaWan() {
		return ToKwaWan;
	}
	public void setToKwaWan(long toKwaWan) {
		ToKwaWan = toKwaWan;
	}
	public long getTaiKokTsui() {
		return TaiKokTsui;
	}
	public void setTaiKokTsui(long taiKokTsui) {
		TaiKokTsui = taiKokTsui;
	}
	public long getNgauTauKwok() {
		return NgauTauKwok;
	}
	public void setNgauTauKwok(long ngauTauKwok) {
		NgauTauKwok = ngauTauKwok;
	}
	public long getShekKipMei() {
		return ShekKipMei;
	}
	public void setShekKipMei(long shekKipMei) {
		ShekKipMei = shekKipMei;
	}
	public long getTsimShaTsui() {
		return TsimShaTsui;
	}
	public void setTsimShaTsui(long tsimShaTsui) {
		TsimShaTsui = tsimShaTsui;
	}
	public long getKnutsfordTerrace() {
		return KnutsfordTerrace;
	}
	public void setKnutsfordTerrace(long knutsfordTerrace) {
		KnutsfordTerrace = knutsfordTerrace;
	}
	public long getHoManTin() {
		return HoManTin;
	}
	public void setHoManTin(long hoManTin) {
		HoManTin = hoManTin;
	}
	public long getYauMaTei() {
		return YauMaTei;
	}
	public void setYauMaTei(long yauMaTei) {
		YauMaTei = yauMaTei;
	}
	public long getCheungShaWan() {
		return CheungShaWan;
	}
	public void setCheungShaWan(long cheungShaWan) {
		CheungShaWan = cheungShaWan;
	}
	public long getLaiChiKok() {
		return LaiChiKok;
	}
	public void setLaiChiKok(long laiChiKok) {
		LaiChiKok = laiChiKok;
	}
	public long getShamShuiPo() {
		return ShamShuiPo;
	}
	public void setShamShuiPo(long shamShuiPo) {
		ShamShuiPo = shamShuiPo;
	}
	public long getWongTaiSin() {
		return WongTaiSin;
	}
	public void setWongTaiSin(long wongTaiSin) {
		WongTaiSin = wongTaiSin;
	}
	public long getTszWanShan() {
		return TszWanShan;
	}
	public void setTszWanShan(long tszWanShan) {
		TszWanShan = tszWanShan;
	}
	public long getSanPoKong() {
		return SanPoKong;
	}
	public void setSanPoKong(long sanPoKong) {
		SanPoKong = sanPoKong;
	}
	public long getLeiYueMun() {
		return LeiYueMun;
	}
	public void setLeiYueMun(long leiYueMun) {
		LeiYueMun = leiYueMun;
	}
	public long getDiamondHill() {
		return DiamondHill;
	}
	public void setDiamondHill(long diamondHill) {
		DiamondHill = diamondHill;
	}
	public long getSheungShui() {
		return SheungShui;
	}
	public void setSheungShui(long sheungShui) {
		SheungShui = sheungShui;
	}
	public long getTaiPo() {
		return TaiPo;
	}
	public void setTaiPo(long taiPo) {
		TaiPo = taiPo;
	}
	public long getTaiWai() {
		return TaiWai;
	}
	public void setTaiWai(long taiWai) {
		TaiWai = taiWai;
	}
	public long getYuenLong() {
		return YuenLong;
	}
	public void setYuenLong(long yuenLong) {
		YuenLong = yuenLong;
	}
	public long getTaiWo() {
		return TaiWo;
	}
	public void setTaiWo(long taiWo) {
		TaiWo = taiWo;
	}
	public long getTuenMun() {
		return TuenMun;
	}
	public void setTuenMun(long tuenMun) {
		TuenMun = tuenMun;
	}
	public long getFoTan() {
		return FoTan;
	}
	public void setFoTan(long foTan) {
		FoTan = foTan;
	}
	public long getSaiKung() {
		return SaiKung;
	}
	public void setSaiKung(long saiKung) {
		SaiKung = saiKung;
	}
	public long getShaTin() {
		return ShaTin;
	}
	public void setShaTin(long shaTin) {
		ShaTin = shaTin;
	}
	public long getTsingYi() {
		return TsingYi;
	}
	public void setTsingYi(long tsingYi) {
		TsingYi = tsingYi;
	}
	public long getFanling() {
		return Fanling;
	}
	public void setFanling(long fanling) {
		Fanling = fanling;
	}
	public long getTsuenWan() {
		return TsuenWan;
	}
	public void setTsuenWan(long tsuenWan) {
		TsuenWan = tsuenWan;
	}
	public long getMaWan() {
		return MaWan;
	}
	public void setMaWan(long maWan) {
		MaWan = maWan;
	}
	public long getShamTseng() {
		return ShamTseng;
	}
	public void setShamTseng(long shamTseng) {
		ShamTseng = shamTseng;
	}
	public long getKwaiFong() {
		return KwaiFong;
	}
	public void setKwaiFong(long kwaiFong) {
		KwaiFong = kwaiFong;
	}
	public long getKwaiChung() {
		return KwaiChung;
	}
	public void setKwaiChung(long kwaiChung) {
		KwaiChung = kwaiChung;
	}
	public long getLoWu() {
		return LoWu;
	}
	public void setLoWu(long loWu) {
		LoWu = loWu;
	}
	public long getTinShuiWai() {
		return TinShuiWai;
	}
	public void setTinShuiWai(long tinShuiWai) {
		TinShuiWai = tinShuiWai;
	}
	public long getLauFaushan() {
		return LauFaushan;
	}
	public void setLauFaushan(long lauFaushan) {
		LauFaushan = lauFaushan;
	}
	public long getMaOnShan() {
		return MaOnShan;
	}
	public void setMaOnShan(long maOnShan) {
		MaOnShan = maOnShan;
	}
	public long getTseungKwanO() {
		return TseungKwanO;
	}
	public void setTseungKwanO(long tseungKwanO) {
		TseungKwanO = tseungKwanO;
	}
	public long getLokMaChau() {
		return LokMaChau;
	}
	public void setLokMaChau(long lokMaChau) {
		LokMaChau = lokMaChau;
	}
	public long getTaiO() {
		return TaiO;
	}
	public void setTaiO(long taiO) {
		TaiO = taiO;
	}
	public long getPingChau() {
		return PingChau;
	}
	public void setPingChau(long pingChau) {
		PingChau = pingChau;
	}
	public long getTungChung() {
		return TungChung;
	}
	public void setTungChung(long tungChung) {
		TungChung = tungChung;
	}
	public long getCheungChau() {
		return CheungChau;
	}
	public void setCheungChau(long cheungChau) {
		CheungChau = cheungChau;
	}
	public long getLantauIsland() {
		return LantauIsland;
	}
	public void setLantauIsland(long lantauIsland) {
		LantauIsland = lantauIsland;
	}
	public long getChekLapKok() {
		return ChekLapKok;
	}
	public void setChekLapKok(long chekLapKok) {
		ChekLapKok = chekLapKok;
	}
	public long getLammaIsland() {
		return LammaIsland;
	}
	public void setLammaIsland(long lammaIsland) {
		LammaIsland = lammaIsland;
	}
	public long getDiscoveryBay() {
		return DiscoveryBay;
	}
	public void setDiscoveryBay(long discoveryBay) {
		DiscoveryBay = discoveryBay;
	}
	public long getPoToiIsland() {
		return PoToiIsland;
	}
	public void setPoToiIsland(long poToiIsland) {
		PoToiIsland = poToiIsland;
	}
	

}
