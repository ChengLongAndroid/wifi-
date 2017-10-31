package test;

import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Test;

import com.hunangy.DbRes.UserRes;
import com.hunangy.absDao.SelectDao;
import com.hunangy.absDao.UserDaoAbs;
import com.ljc.util.DBUtil;

public class TestServer {
	//10.66.130.30:3306
	@Test
	public void testServer() {
		String IP = "594e730c3c874.gz.cdb.myqcloud.com";
		int port = 11870;
		String name = "wifiprobedb";
		Connection conn = DBUtil.getConnet(IP, port, name);
		System.out.println("连接名"+conn);
		
//		JSONObject obj = new JSONObject(act.toString());  
//		String action=obj.getString("action").toString();
		String account="123456";
		String password="123456";
		String NameID="123456";
		String start="2017-6-18-20";
		String ent="2017-6-23-20";
		System.err.println(NameID+"---"+start+"---"+ent);
		String data="";
		try {
			 data=SelectDao.QueryData(NameID, start, ent); //进行查询
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(data==null){
			System.out.println("无数据");
			
		}else {
			System.out.println("显示数据"+data.toString());
			
		}
	}

}
