package com.hunangy.absDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.hunangy.DbRes.ProbeDataRes;
import com.hunangy.DbRes.UserRes;


public class ProbeDataDao {
	//INSERT INTO `wifiprobedatadb`.`probedata` (`probeDataId`, `mac`, `action`, `time`, `tc`, `probeAttrbutesTable_probeAttrId`) VALUES ('fd', 'fd', '1', '1924-04-24', 'fd', 'fdsf');	
		public static boolean Save(ProbeDataRes date,Connection conn){
			boolean x = false;
			try {
				
				if (conn != null) {
					try {

						java.util.Date date2 = new java.util.Date();
						Timestamp timeStamp = new Timestamp(date2.getTime());
						
						String sql_query2 = "INSERT INTO probedata ( mac, action, time, tc, essid, probeAttrbutesTable_probeAttrId) VALUES (?,?,?,?,?,?)";
						PreparedStatement ps = conn.prepareStatement(sql_query2);						
						ps.setString(1, date.getMac());
						ps.setInt(2, date.getAction());						
						ps.setTimestamp(3,timeStamp);
						ps.setInt(4, date.getTc());
						ps.setString(5, date.getEssid());
						ps.setString(6, date.getProbeAttrbutesTable_probeAttrId());
						

						boolean rs = ps.execute();

						if (!rs) {
							System.out.println("yes-------");
							x = true;
						} else {
							x = false;
							System.out.println("no----");
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("报错了");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return x;

		}

//select * from wifiprobedatadb.probedata where time>'2017-06-21 14:01:25' and time<'2017-06-21 15:01:56';
		public static List<ProbeDataRes> queryprobe(String start,String ent,String Mac,String name,Connection conn) {  //通过时间段查数据  修改
			
			List<ProbeDataRes> list=new ArrayList<>();
			int i=0;
			try {
				
				if (conn != null) {
					try {
						
						String sql_query2 = "select * from probedata where time>'"+start+"' and time<'"+ent+"' and mac='"+Mac+"' and probeAttrbutesTable_probeAttrId='"+name+"'";				
						PreparedStatement ps = conn.prepareStatement(sql_query2);															
						ResultSet rs = ps.executeQuery();
						
						while (rs.next()) {
					//	System.out.println(rs.getString(1)+"--------- "+rs.getString(2)+"--------- "+rs.getString(3)+"  "+rs.getTimestamp(4));
						ProbeDataRes us=new ProbeDataRes(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getTimestamp(4));
						list.add(us);

							System.out.println("成功");
						
						} 
						
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("报错了");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			int con=list.size();
			
		
			return list;
			
		
	}		
		
		public static List<String> queryrepeatlist(String start,String ent,String name,Connection conn) {  //获取去重mac地址
		//	System.out.println(start+"----"+ent);
			List<String> list=new ArrayList<>();
			int i=0;
			try {
				
				if (conn != null) {
					try {
						
						String sql_query2 = "select distinct mac from probedata where time>'"+start+"' and time<'"+ent+"' and probeAttrbutesTable_probeAttrId='"+name+"'";				
						PreparedStatement ps = conn.prepareStatement(sql_query2);															
						ResultSet rs = ps.executeQuery();
						
						while (rs.next()) {						
						//ProbeDataRes us=new ProbeDataRes(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4));
						list.add(rs.getString(1));
							System.out.println("成功");
						
						} 
						
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("报错了");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			int con=list.size();
			
		
			return list;
			
		
	}		
		
	private static java.util.Date getStartTime() {
		// TODO Auto-generated method stub
		return null;
	}
}
