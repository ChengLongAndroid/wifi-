package com.hunangy.absDao;

import java.sql.Connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hunangy.DbRes.ProbeDataRes;
import com.hunangy.absDao.ProbeDataDao;
import com.ljc.util.DBUtil;

public class SelectDao { // 查询
//	static String IP = "594e730c3c874.gz.cdb.myqcloud.com";
//	static int port = 11870;
	static String IP = "127.0.0.1";
	static int port=3306;
	
	
	static String name = "wifiprobedatadb";
	final static Connection conn = DBUtil.getConnet(IP, port, name);
	//System.out.println("main  " + conn);

	public static void main(String[] args) throws ParseException {

		
//		int inShop = 0, notInShop = 0; // inShop与notInShop
//										// 分别代表进入店铺范围的人数与未进入店铺范围的人数
//		int newPerson = 0, oldPerson = 0; // newPerson与oldPerson 分别代表新顾客与老顾客 注意
//											// 新顾客+老顾客 == 进入店铺范围的人数
//		int quickly = 0, depth = 0; // quickly月depth 分别代表跳出量与深访量 注意 跳出量 + 深访量 ==
//									// 进入店铺范围的人数
//
//		List<Float> Timeminus = new ArrayList<>();// 驻留时间
//		List<Float> Period = new ArrayList<>();
//		String start = "", ent = "", NameID = "";
//		NameID = "123456";
//		start = "2017-06-22 18:10:07";
//		ent = "2017-06-22 19:10:07";
//
//		List<String> list2 = new ArrayList<>();
//		list2 = ProbeDataDao.queryrepeatlist(start, ent, NameID, conn);
//		int con = list2.size();
//		for (int i = 0; i < list2.size(); i++) {// 统计 进入店铺范围的人数与未进入店铺范围的人数
//
//			List<ProbeDataRes> list = new ArrayList<>();
//			list = ProbeDataDao.queryprobe(start, ent, list2.get(i), NameID,
//					conn); // 查出某条mac地址在某范围时间内的所有数据
//			System.out.println("查询数据为 :" + list.size() + "条  --  "
//					+ list.toString());
//			int insum0 = 0, insum1 = 0, period0 = 0;
//			for (ProbeDataRes probeDataRes : list) {
//
//				if (probeDataRes.getAction() == 0) {
//					insum0++;
//				}
//				if (probeDataRes.getAction() == 1) {
//					insum1++;
//				}
//
//				if (probeDataRes.getAction() == 3) {
//					period0++;
//				}
//
//				System.err.println(" -insum0- " + insum0 + " -insum1- "
//						+ insum1);
//			}
//			if (insum0 == 0 && insum1 == 0) {
//				notInShop++;
//				list2.remove(i);
//
//			} else if (insum1 < 3) {
//				newPerson++;
//			}
//			float timeminus = 0;
//			float period = 0;
//
//			if (insum0 > 0 && insum1 > 0) { // 进行驻店时长查询 存list表
//				String d1 = null, d2 = null;
//
//				for (int j = 0; j < list.size() - 1; j++) {
//					if (list.get(j).getAction() == 0 && d1 == null) {
//						d1 = list.get(j).getTime().toString();
//					} else if (list.get(j).getAction() == 1 && d1 != null
//							&& list.get(j + 1).getAction() == 0) {
//						d2 = list.get(j).getTime().toString();
//					}
//
//					if (d1 != null && d2 != null) {
//						System.out.println(d2 + "-----时间-----" + d1);
//						float s = TimeMinus(d2, d1);
//						if (s < 60)
//							s = 60;
//						timeminus += s;
//
//						System.out.println("总差值为： " + timeminus + "  差值为:" + s);
//						d1 = null;
//						d2 = null;
//					}
//
//				}
//				if (timeminus < 60) {
//					timeminus = 60;
//				}
//				Timeminus.add(timeminus);
//
//			}
//
//			if (insum0 > 0 && period0 > 2) { // 进行访问周期查询 存list表
//				String d1 = null, d2 = null;
//				List<String> periodlist = new ArrayList<>();
//				for (int j = 0; j < list.size(); j++) {
//					if (list.get(j).getAction() == 3) {
//						periodlist.add(list.get(j).getTime().toString());
//					}
//				}
//
//				for (int j = periodlist.size() - 1; j > 0; j--) { // 修改
//					d1 = periodlist.get(j);
//					d2 = periodlist.get(j - 1);
//					System.out.println(d1 + "-----访问时间-----" + d2);
//
//					float s = TimeMinus(d1, d2);
//					if (s < 60) {
//						s = 60;
//					}
//
//					period += s;
//					System.out.println("访问总差值为： " + Period + "  差值为:" + s);
//
//				}
//
//				Period.add(period);
//
//			}
//
//			inShop = list2.size();
//			oldPerson = (list2.size() - newPerson);
//
//		}
//
//		// 驻店时长，访问周期，跳出率，深访量
//		int[] timecount = new int[4];
//
//		int[] visitCycle = new int[4];
//		for (int i = 0; i < Timeminus.size(); i++) {
//			if (Timeminus.get(i) < 300) { // 跳出率
//				quickly++;
//			}
//			if (Timeminus.get(i) < 86400) {// 小于一天86400，小于一周604800，小于一个月2592000
//				timecount[0]++;
//			} else if (Timeminus.get(i) > 86401 && Timeminus.get(i) < 604800) {
//				timecount[1]++;
//			} else if (Timeminus.get(i) > 604801 && Timeminus.get(i) < 2592000) {
//				timecount[2]++;
//			} else
//				timecount[3]++;
//		}
//
//		for (int i = 0; i < Period.size(); i++) {
//
//			if (Period.get(i) < 86400) {// 小于一天86400，小于一周604800，小于一个月2592000
//				visitCycle[0]++;
//			} else if (Period.get(i) > 86401 && Period.get(i) < 604800) {
//				visitCycle[1]++;
//			} else if (Period.get(i) > 604801 && Period.get(i) < 2592000) {
//				visitCycle[2]++;
//			} else
//				visitCycle[3]++;
//		}
//
//		System.out.println(" 总共条数为: " + con + " 进入店铺为: " + inShop + " 未入店为: "
//				+ notInShop + " 新客户有: " + newPerson + "  老客户 : " + oldPerson
//				+ "跳出率" + quickly + "深访率" + (inShop - quickly) + "  停留时间为： "
//				+ Timeminus.toString() + "时间个数" + Timeminus.size() + "访问时间"
//				+ Period.toString() + "访问时间个数" + Period.size() + " 驻店时长:"
//				+ timecount[0] + "  " + timecount[1] + "  " + timecount[2]
//				+ "  " + timecount[3] + "访问周期" + visitCycle[0] + "  "
//				+ visitCycle[1] + "  " + visitCycle[2] + "  " + visitCycle[3]);
	}

	public static  String QueryData(String NameID,String start,String ent) throws ParseException {
		int inShop = 0, notInShop = 0; // inShop与notInShop
		// 分别代表进入店铺范围的人数与未进入店铺范围的人数
		int newPerson = 0, oldPerson = 0; // newPerson与oldPerson 分别代表新顾客与老顾客 注意
		// 新顾客+老顾客 == 进入店铺范围的人数
		int quickly = 0, depth = 0; // quickly月depth 分别代表跳出量与深访量 注意 跳出量 + 深访量 ==
		// 进入店铺范围的人数
		String Data="{";
		List<Float> Timeminus = new ArrayList<>();// 驻留时间
		List<Float> Period = new ArrayList<>();
//		String start = "", ent = "", NameID = "";
//		NameID = "123456";
//		start = "2017-06-22 18:10:07";
//		ent = "2017-06-22 19:10:07";

		List<String> list2 = new ArrayList<>();
		list2 = ProbeDataDao.queryrepeatlist(start, ent, NameID, conn);
		int con = list2.size();
		if(con!=0){
		for (int i = 0; i < list2.size(); i++) {// 统计 进入店铺范围的人数与未进入店铺范围的人数

			List<ProbeDataRes> list = new ArrayList<>();
			list = ProbeDataDao.queryprobe(start, ent, list2.get(i), NameID,
					conn); // 查出某条mac地址在某范围时间内的所有数据
//			System.out.println("查询数据为 :" + list.size() + "条  --  "
//					+ list.toString());
			int insum0 = 0, insum1 = 0, period0 = 0;
			for (ProbeDataRes probeDataRes : list) {

				if (probeDataRes.getAction() == 0) {
					insum0++;
				}
				if (probeDataRes.getAction() == 1) {
					insum1++;
				}

				if (probeDataRes.getAction() == 3) {
					period0++;
				}

//				System.err.println(" -insum0- " + insum0 + " -insum1- "
//						+ insum1);
			}
			if (insum0 == 0 && insum1 == 0) {
				notInShop++;
				list2.remove(i);

			} else if (insum1 < 3) {
				newPerson++;
			}
			float timeminus = 0;
			float period = 0;

			if (insum0 > 0 && insum1 > 0) { // 进行驻店时长查询 存list表
				String d1 = null, d2 = null;

				for (int j = 0; j < list.size() - 1; j++) {
					if (list.get(j).getAction() == 0 && d1 == null) {
						d1 = list.get(j).getTime().toString();
					} else if (list.get(j).getAction() == 1 && d1 != null
							&& list.get(j + 1).getAction() == 0) {
						d2 = list.get(j).getTime().toString();
					}

					if (d1 != null && d2 != null) {
						//System.out.println(d2 + "-----时间-----" + d1);
						float s = TimeMinus(d2, d1);
						if (s < 60)
							s = 60;
						timeminus += s;

						//System.out.println("总差值为： " + timeminus + "  差值为:" + s);
						d1 = null;
						d2 = null;
					}

				}
				if (timeminus < 60) {
					timeminus = 60;
				}
				Timeminus.add(timeminus);

			}

			if (insum0 > 0 && period0 > 2) { // 进行访问周期查询 存list表
				String d1 = null, d2 = null;
				List<String> periodlist = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).getAction() == 3) {
						periodlist.add(list.get(j).getTime().toString());
					}
				}

				for (int j = periodlist.size() - 1; j > 0; j--) { // 修改
					d1 = periodlist.get(j);
					d2 = periodlist.get(j - 1);
				//	System.out.println(d1 + "-----访问时间-----" + d2);

					float s = TimeMinus(d1, d2);
					if (s < 60) {
						s = 60;
					}

					period += s;
					//System.out.println("访问总差值为： " + Period + "  差值为:" + s);

				}

				Period.add(period);

			}

			inShop = list2.size();
			oldPerson = (list2.size() - newPerson);

		}

		// 驻店时长，访问周期，跳出率，深访量
		int[] timecount = new int[4];

		int[] visitCycle = new int[4];
		for (int i = 0; i < Timeminus.size(); i++) {
			if (Timeminus.get(i) < 300) { // 跳出率
				quickly++;
			}
			if (Timeminus.get(i) < 86400) {// 小于一天86400，小于一周604800，小于一个月2592000
				timecount[0]++;
			} else if (Timeminus.get(i) > 86401 && Timeminus.get(i) < 604800) {
				timecount[1]++;
			} else if (Timeminus.get(i) > 604801 && Timeminus.get(i) < 2592000) {
				timecount[2]++;
			} else
				timecount[3]++;
		}

		for (int i = 0; i < Period.size(); i++) {

			if (Period.get(i) < 86400) {// 小于一天86400，小于一周604800，小于一个月2592000
				visitCycle[0]++;
			} else if (Period.get(i) > 86401 && Period.get(i) < 604800) {
				visitCycle[1]++;
			} else if (Period.get(i) > 604801 && Period.get(i) < 2592000) {
				visitCycle[2]++;
			} else
				visitCycle[3]++;
		}

		depth=(inShop - quickly);
//		System.out.println(" 总共条数为: " + con + " 进入店铺为: " + inShop + " 未入店为: "
//				+ notInShop + " 新客户有: " + newPerson + "  老客户 : " + oldPerson
//				+ "跳出率" + quickly + "深访率" + (inShop - quickly) + "  停留时间为： "
//				+ Timeminus.toString() + "时间个数" + Timeminus.size() + "访问时间"
//				+ Period.toString() + "访问时间个数" + Period.size() + " 驻店时长:"
//				+ timecount[0] + "  " + timecount[1] + "  " + timecount[2]
//				+ "  " + timecount[3] + "访问周期" + visitCycle[0] + "  "
//				+ visitCycle[1] + "  " + visitCycle[2] + "  " + visitCycle[3]);
		
		
		
		//{"state":"success","shopFlow":[{"inShop":60,"notInShop":80}],"person":[{"oldPerson":75,"newPerson":65}],"rate":[{"quickly":32,"depth":28}],"stayTimeCount":[{"timeOne":20,"timeTwo":20,"timeThree":10,"timeFour":10}],"visitCycle":[{"timeOne":20,"timeTwo":20,"timeThree":10,"timeFour":10}]}

		Data+="\"state\":\"success\",";

		Data+="\"shopFlow\":[{\"inShop\":"+inShop+",\"notInShop\":"+notInShop+"}],";
		Data+="\"person\":[{\"oldPerson\":"+oldPerson+",\"newPerson\":"+newPerson+"}],";
		Data+="\"rate\":[{\"quickly\":"+quickly+",\"depth\":"+depth+"}],";
		Data+="\"stayTimeCount\":[{\"timeOne\":"+timecount[0]+",\"timeTwo\":"+timecount[1]+",\"timeThree\":"+timecount[2]+",\"timeFour\":"+timecount[3]+"}],";
		Data+="\"visitCycle\":[{\"timeOne\":"+visitCycle[0]+",\"timeTwo\":"+visitCycle[1]+",\"timeThree\":"+visitCycle[2]+",\"timeFour\":"+visitCycle[3]+"}]";
		Data+="}";
		}else if(con==0)
			Data=null;
		return Data;

	}

	public static float TimeMinus(String d1, String d2) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//System.out.println(sdf.parse(d2).getTime() + "------------"
		//		+ sdf.parse(d1).getTime());
		float m = sdf.parse(d2).getTime() - sdf.parse(d1).getTime();
		/* 根据你的需求进行单位转换 */
		System.out.println("相差秒数:" + m / 1000);
		// System.out.println("相差天数:"+ ( m / (1000 * 60 * 60 * 24) ) );
		return (float) m / 1000;
	}
}
