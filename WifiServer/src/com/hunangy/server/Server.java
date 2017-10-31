package com.hunangy.server;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.hunangy.DbRes.UserRes;
import com.hunangy.absDao.SelectDao;
import com.hunangy.absDao.UserDaoAbs;
import com.ljc.util.DBUtil;
@WebServlet(name = "Server", urlPatterns = "/Server")
public class Server extends HttpServlet{
//	String IP="594e730c3c874.gz.cdb.myqcloud.com";
	String IP="127.0.0.1";
//	int port=11870;
	int port=3306;
	String name="wifiprobedatadb";
	String name2="wifiprobedb";
	
	final Connection conn=DBUtil.getConnet(IP,port,name);
	final Connection conn2=DBUtil.getConnet(IP,port,name2);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String act = req.getParameter("jsonData");
		
		System.out.println("获取数据"+act);
		
		
		
		JSONObject obj = new JSONObject(act.toString());  
		String action=obj.getString("action").toString();
		
		int pr1=0;
		if(action.equals("login")){	//{"action":"login","account":"liuyangdashuaibi","password":"shidetashi"} conn2
			String account=obj.getString("account").toString();
			String password=obj.getString("password").toString();
			System.out.println(account+"    "+password);
			List<UserRes> ulistList=new ArrayList<>();
			ulistList=UserDaoAbs.queryUserBy(account,conn2);
//			for (UserRes userRes : ulistList) {
//				System.out.println(userRes.toString());
//			}
			
			String pinString="{";
			String probeId="[";
			if (ulistList.size()!=0) {
				for (UserRes userRes : ulistList) {
					probeId+="{"+"\"probeId\":"+userRes.getProbeAttrId()+"},";										
					System.out.println(userRes);					
				}
				probeId=probeId.substring(0,probeId.length()-1)+"]";
				
				if(ulistList.get(0).getPassword().equals(password)){
				//	JSONObject probeIds=new JSONObject();
					JSONObject json=new JSONObject();
					pinString+="\"state\":\"success\",";
					pinString+="\"userName\":\""+ulistList.get(0).getUsername()+"\",";
					pinString+="\"range\":"+ulistList.get(0).getRate()+",";
					//pinString+="\"probeIds\":\""+probeId+"\",";
					pinString+="\"probeIds\":"+probeId+"";
					//json.put("state", "success");
					//json.put("userName", ulistList.get(0).getUsername());
					//json.put("range",ulistList.get(0).getRate());						      
			      //  probeIds.put("probeId", probeId);
			        
			       // json.put( "probeIds", probeId);
					pinString+="}";
			        resp.getOutputStream().write(pinString.getBytes("utf-8"));
					
				}else {
					resp.getOutputStream().write("{\"state\":\"failure\",\"errorCode\":2}".getBytes("utf-8"));
				}
				//{"state":"success","userName":"刘样大帅B","range":20,"probeIds":[{"probeId":456782},{"probeId":789125},{"probeId":789456}]}

				//{"state":"failure","errorCode":1}  1代表账号不存在,2代表密码错误，3代表服务器维护,4代表json解析错误,5未知错误。

			}else {
				resp.getOutputStream().write("{\"state\":\"failure\",\"errorCode\":1}".getBytes("utf-8"));
			}
	
		}else if (action.equals("query")) {
			//{"action":"query","probeId":123456,"beginDate","2016-6-18-20","endDate","2016-6-19-15"}  conn 
			String NameID=String.valueOf(obj.getInt("probeId")).toString();
			String start=obj.getString("beginDate").toString();
			String ent=obj.getString("endDate").toString();
			//System.err.println(NameID+"---"+start+"---"+ent);
			String data="";
			try {
				 data=SelectDao.QueryData(NameID, start, ent); //进行查询
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(data==null){
				System.out.println("无数据");
				resp.getOutputStream().write("{\"state\":\"failure\",\"errorCode\":1}".getBytes("utf-8"));
			}else {
				System.out.println("显示数据"+data.toString());
				resp.getOutputStream().write(data.getBytes("utf-8"));
			}
			
		} else if (action.equals("modify")) {
			String account=obj.getString("account");
			String userName=obj.getString("userName");
			String password=obj.getString("password");
			int range=Integer.valueOf(obj.getString("range"));
			UserRes userRes=new UserRes(account,userName,password,range);
			System.out.println(userRes);
			if (UserDaoAbs.UpDataUser(userRes,conn2)) {
				resp.getOutputStream().write("{\"state\":\"success\"}".getBytes("utf-8"));
			}else resp.getOutputStream().write("{\"state\":\"failure\"}".getBytes("utf-8"));
			//{"action":"modify","account":"2477046978","userName":"刘样是大帅比","password":"123456","range":"100"}
		}
		
		
		
		
		
	}

}
