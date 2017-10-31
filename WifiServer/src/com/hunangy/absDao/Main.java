package com.hunangy.absDao;

import java.io.BufferedReader;


import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.crypto.Mac;
import javax.sound.sampled.Port;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.hunangy.DbRes.ProbeAttrRes;
import com.hunangy.DbRes.ProbeDataRes;
import com.hunangy.DbRes.ProbeStorageRes;
import com.hunangy.DbRes.ShopRes;
import com.hunangy.DbRes.UserRes;
import com.ljc.util.DBUtil;


/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG       永不修改

                       .::::.
                     .::::::::.
                    :::::::::::
                 ..:::::::::::'
              '::::::::::::'
                .::::::::::
           '::::::::::::::..
                ..::::::::::::.
              ``::::::::::::::::
               ::::``:::::::::'        .:::.
              ::::'   ':::::'       .::::::::.
            .::::'      ::::     .:::::::'::::.
           .:::'       :::::  .:::::::::' ':::::.
          .::'        :::::.:::::::::'      ':::::.
         .::'         ::::::::::::::'         ``::::.
     ...:::           ::::::::::::'              ``::.
    ```` ':.          ':::::::::'                  ::::..
                       '.:::::'                    ':'````..

 						江城子 . 程序员之歌
 
					  十年生死两茫茫，写程序，到天亮。
					      千行代码，Bug何处藏。
					  纵使上线又怎样，朝令改，夕断肠。
					
					 领导每天新想法，天天改，日日忙。
					     相顾无言，惟有泪千行。
					  每晚灯火阑珊处，夜难寐，加班狂。
*/

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh"); 
//		Date date =new Date();
		//wifiprobedatadb
		//wifiprobedb
		//transportdb
		
		
		//String IP="594e730c3c874.gz.cdb.myqcloud.com";
		//int port=11870;
		
		String IP="127.0.0.1";
		int port=3306;
		String name="wifiprobedatadb";

		
		final Connection conn=DBUtil.getConnet(IP,port,name);
		System.out.println("main  "+conn);
		//6月14号	socket拼接 程龙

		
		new Thread(){
			
			@Override
			public void run() {
				try {
					ServerSocket ss = new ServerSocket(54331);
					while (true) {
						System.out.println("等待客户端连接");
						Socket c = ss.accept();
						try {
							// 接收信息
							BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream(), "utf-8"));
							String str = "";
							str = br.readLine();
							System.out.println(str);
							
							JSONObject obj = new JSONObject(str.toString());  
							JSONArray obj2 = obj.getJSONArray("data");
							String name=obj.getString("probeId").toString();
							System.out.println(name);
							List<ProbeDataRes> list=new ArrayList<>();
							for (int i = 0; i < obj2.length(); i++) {  
							    JSONObject temp = new JSONObject(obj2.get(i).toString());
							    ProbeDataRes asDataRes=new ProbeDataRes(temp.getString("mac"),temp.getInt("action"),temp.getString("tmc"),name);
							    if (ProbeDataDao.Save(asDataRes, conn)) {
									System.out.println("成功");
								}else System.out.println("失败");
							    list.add(asDataRes);
							} 
							
							
						
							
							// 向客户端发送信息
							PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(c.getOutputStream())),true);
							Scanner sc = new Scanner(System.in);
							//String s = sc.nextLine();
							Random random=new Random();
							pw.println("服务端接受成功："+" "+ " ,服务器的IP是:" + ss.getLocalSocketAddress());

							br.close();
							pw.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		
		
	
		
		
		
		
		
		
		 
		
//获取探针存储数据进行查询操作
//		List<ProbeDataRes> list=new ArrayList<>();
//		list=ProbeDataDao.queryprobe("2017-06-21 14:01:25","2017-06-21 14:21:56",conn);
//		for (ProbeDataRes probeDataRes : list) {
//			System.out.println("-----------------------------------"+probeDataRes.toString());
//		}
//		
		
		
		
		
	
//		  ProbeDataRes asDataRes=new ProbeDataRes("gfadgfdg",1,"vcxzbvczb","探针1号");
//		    if (ProbeDataDao.Save(asDataRes, conn)) {
//				System.out.println("成功");
//			}else System.out.println("失败");
		
		

		
//		java.util.Date a = new java.util.Date();
//		System.out.println(a);
//		java.sql.Date b = new java.sql.Date(a.getTime());
//		System.out.println(b);
		
//		ProbeDataRes pr=new ProbeDataRes("hh","hh",1,a,2,"hhh");
//		System.out.println(pr.toString());
//		if (ProbeDataDao.Save(pr, conn)) {
//			System.out.println("成功");
//		}else System.out.println("失败");
		
		
		
		
		
		//UserRes user=UserDaoAbs.queryUserByAccount("fsd", conn);  //查
//		UserRes user=new UserRes("dsa4","1234","12345");  //插
//		if(UserDaoAbs.saveUser(user, conn)){
//			System.out.println("成功");
//		}else
//			System.out.println("失败");	
		
		
//		List<UserRes> s=UserDaoAbs.queryUserByName("737861752",conn);
//		for (UserRes userRes : s) {
//			System.out.println(userRes.toString());
//		}
		
		
//		System.out.println(user.toString());
		
//		ShopRes shop=new ShopRes("f","23","23",24.1,"fsd");
//		if(ShopDaoAbs.saveShop(shop, conn)){
//		System.out.println("成功");
//	}else
//		System.out.println("失败");
		
//		ShopRes u=ShopDaoAbs.queryShopById("f", conn);
//		System.out.println(u.toString());
		
		
//		List<ShopRes> u=ShopDaoAbs.queryShopByName("23", conn);
//		for (ShopRes shopRes : u) {
//			System.out.println(shopRes.toString());
//		}
		
		
//		ProbeAttrRes shop=new ProbeAttrRes("dsa","dsa",12,45,45,"asd","rr","66");
//		if(ProbeAttrDaoAbs.saveProbeAttr(shop, conn)){
//			System.out.println("成功");
//		}else
//			System.out.println("失败");
//		ProbeAttrRes u=ProbeAttrDaoAbs.queryProbeAttrById("ds", conn);
//		System.out.println(u.toString());
		
		
		
//		List<ProbeAttrRes> list =ProbeAttrDaoAbs.queryProbeAttrByUserAccount("rr", conn);
//		for (ProbeAttrRes probeAttrRes : list) {			
//			System.out.println(probeAttrRes.toString());
//		}
		
		
		//System.out.println(bartDateFormat.format(date));
		//System.out.println(); 		
//		ProbeStorageRes u=new ProbeStorageRes("789",date,"45",12,"ds");
//		if(ProbeStorageDaoAbs.saveProbeAttr(u, conn)){
//			System.out.println("成功");
//	}else
//		System.out.println("失败");
		//System.out.println(ProbeStorageDaoAbs.queryProbeAttrById("12", conn));
		
//		String u="2017-5-6";
//		SimpleDateFormat dd=new SimpleDateFormat("yy-MM-dd");		
//		java.util.Date d1=dd.parse(u);
//		System.out.println(d1);
		
		
	}




}











