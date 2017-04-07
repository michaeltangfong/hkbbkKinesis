package hkbbkKinesisApplication.utils;

import com.amazonaws.services.kinesis.clientlibrary.lib.worker.InitialPositionInStream;

public class Constants {
	
	public static String[] regions = {
	           "上環","大坑","山頂","中環","蘇豪","蘭桂坊","天后","太古","北角","半山","石澳","西環",
	           "赤柱","金鐘","柴灣","灣仔","西灣河","杏花村","香港仔","淺水灣","深水灣","跑馬地","筲箕灣",
	           "銅鑼灣","鴨脷洲","薄扶林","數碼港","鰂魚涌","太子","佐敦","旺角","油塘","紅磡","美孚","彩虹",
	           "樂富","藍田","觀塘","九龍城","九龍塘","九龍灣","土瓜灣","大角咀","牛頭角","石硤尾","尖沙咀","諾士佛臺",
	           "何文田","油麻地","長沙灣","荔枝角","深水埗","黃大仙","慈雲山","新蒲崗","鯉魚門","鑽石山","上水","大埔",
	           "大圍","元朗","太和","屯門","火炭","西貢","沙田","青衣","粉嶺","荃灣","馬灣","深井","葵芳","葵涌","羅湖",
	           "天水圍","流浮山","馬鞍山","將軍澳","落馬洲","大澳","坪洲","東涌","長洲","大嶼山","赤鱲角","南丫島","愉景灣","蒲苔島" 
	           };
	
	public static String[] regionsEnglish = {
			"sheungWan","tinHang","thePeak","central","soho","lanKwaiFong","tinHau","taiKoo","northPoint","midLevels","shekO","westernDistrict",
			"stanley","admiralty","chaiWan","wanChai","saiWanHo","hengFaChuen","aberdeen","repulseBay","deepWaterbay","happyValley","shauKeiWan",
			"causewayBay","apLeiChau","pokFuLam","cyberport","quarryBay","princeEdward","jordan","mongKok","yauTong","hungHom","meiFoo","choiHung",
			"lokFu","lamTin","kwunTong","kowloonCity","kowloonTong","kowloonBay","toKwaWan","taiKokTsui","ngauTauKwok","shekKipMei","tsimShaTsui","knutsfordTerrace",
			"hoManTin","yauMaTei","cheungShaWan","laiChiKok","shamShuiPo","wongTaiSin","tszWanShan","sanPoKong","leiYueMun","diamondHill","sheungShui","taiPo",
			"taiWai","yuenLong","taiWo","tuenMun","foTan","saiKung","shaTin","tsingYi","fanling","tsuenWan","maWan","shamTseng","kwaiFong","kwaiChung","loWu",
			"tinShuiWai","lauFaushan","maOnShan","tseungKwanO","lokMaChau","taiO","pingChau","tungChung","cheungChau","lantauIsland","chekLapKok","lammaIsland","discoveryBay","poToiIsland"
	};
	/* 
	 * Sheung Wan, Tin Hau , The Peak, Central, Soho, Lan Kwai Fong , Tin Hau, Tai Koo , North Point , Mid-Levels, Shek O, Western District
	 * Stanley , Admiralty, Chai Wan, Wan Chai, Sai Wan Ho, Heng Fa Chuen, Aberdeen, Repulse Bay, Deep Water bay, Happy Valley, Shau Kei Wan
	 * Causeway Bay, Ap Lei Chau, Pok Fu Lam, Cyberport, Quarry Bay, Prince Edward, Jordan, Mong Kok, Yau Tong, Hung Hom, Mei Foo, Choi Hung
	 * Lok Fu, Lam Tin, Kwun Tong, Kowloon City, Kowloon Tong, Kowloon Bay, To Kwa Wan, Tai Kok Tsui, Ngau Tau Kwok, Shek Kip Mei, Tsim Sha Tsui, Knutsford Terrace 
	 * Ho Man Tin, Yau Ma Tei, Cheung Sha Wan, Lai Chi Kok, Sham Shui Po, Wong Tai Sin, Tsz Wan Shan, San Po Kong, Lei Yue Mun, Diamond Hill, Sheung Shui, Tai Po
	 * Tai Wai, Yuen Long, Tai Wo, Tuen Mun, Fo Tan, Sai Kung, Sha Tin, Tsing Yi, Fanling, Tsuen Wan, Ma Wan, Sham Tseng, Kwai Fong, Kwai Chung, Lo Wu
	 * Tin Shui Wai, Lau Fau shan, Ma On Shan, Tseung Kwan O, Lok Ma Chau, Tai O, Ping Chau, Tung Chung, Cheung Chau, Lantau Island, Chek Lap Kok, Lamma Island, Discovery Bay, Po Toi Island
	 *Just use ArrayList.contains(desiredElement). For example, if you're looking for the conta1 account from your example, you could use something like:

		if (lista.contains(conta1)) {
		    System.out.println("Account found");
		} else {
		    System.out.println("Account not found");
	}
	 */
	
	public static final String STREAM_NAME = "hkbbk_ad_steam";

	public static final String APPLICATION_NAME = "hkbbk_kinesis_steam";
    
	public static final String STREAM_REGION = "us-east-1";

    // Initial position in the stream when the application starts up for the first time.
    // Position can be one of LATEST (most recent data) or TRIM_HORIZON (oldest available data)
	public static final InitialPositionInStream KINESIS_INITIAL_POSITION_IN_STREAM =
            InitialPositionInStream.LATEST;
	
	// 60000L = 1 minute
	// Reporting interval
	public static final long REPORTING_INTERVAL_MILLIS = 60000L; // 1 minute
	

    // Checkpointing interval
	public static final long CHECKPOINT_INTERVAL_MILLIS = 60000L ; // 1 minute


	
}
