package com.hunangy.absDao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.hunangy.DbRes.ProbeAttrRes;
import com.hunangy.DbRes.ProbeStorageRes;
import com.hunangy.DbRes.UserRes;

public abstract class ProbeStorageDaoAbs {  
	public static boolean saveProbeAttr(ProbeStorageRes probeStorage,Connection conn) {  // 保存探针属性,以及开始时间
		boolean x=false ;
		try {
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd"); 
			
			
			if (conn != null) {
				try {
					System.out.println(probeStorage.getProbeAttributesTable_probeAttrId()+"  "+probeStorage.getProbeStorageId()+"  "+probeStorage.getServerIp()+"  "+probeStorage.getServerPost()+"  "+probeStorage.getStartTime());
					String sql_query2="INSERT INTO probestoragetable (prodeStorageId, startTime, serverIp, serverPost, probeAttributesTable_probeAttrId) VALUES (?,?,?,?,?)";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
					ps.setString(1, probeStorage.getProbeStorageId());
					ps.setDate(2,new java.sql.Date(probeStorage.getStartTime().getTime()));					
					ps.setString(3, probeStorage.getServerIp());
					ps.setInt(4, probeStorage.getServerPost());
					ps.setString(5, probeStorage.getProbeAttributesTable_probeAttrId());
										
					boolean rs = ps.execute();
					
					if (!rs) {						
						System.out.println("yes-------");
						x=true;
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
	//

	public static ProbeStorageRes queryProbeStorageById(String probeStorageId,Connection conn) { //查询探针属性ID
		ProbeStorageRes u=null;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2 = "SELECT * FROM probestoragetable where prodeStorageId='"+probeStorageId+"'";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
					//ps.setString(1, probeStorageId);					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						
						u=new ProbeStorageRes(rs.getString(1),rs.getDate(2),rs.getDate(3),rs.getString(4),rs.getInt(5),rs.getString(6));
						
						System.out.println("成功");
					
					} else {
						
						System.out.println("失败");
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("报错了");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
		
		
	}
	public static ProbeStorageRes queryProbeAttrByIdAndTime(String probeAttId, Date time,Connection conn) { //探针的ID和时间属性查询   时间未确定
		//SELECT * FROM wifiprobedb.probestoragetable where startTime='2017-03-14' and probeAttributesTable_probeAttrId='ds';  2017-03-14
//		sql.Date也有时间的
//		如果不想用oracle的to_date函数，可以自己生成sql.Date对象
//		String s = "2012-06-21 00:10:00";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date d1 = sdf.parse(s); //先把字符串转为util.Date对象
		java.sql.Date d2 = new java.sql.Date(time.getTime()); //再转换为sql.Date对象
		ProbeStorageRes u=null;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2 = "SELECT * FROM wifiprobedb.probestoragetable where startTime='"+d2+"' and probeAttributesTable_probeAttrId='"+probeAttId+"'";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
					//ps.setString(1, probeStorageId);					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						
						u=new ProbeStorageRes(rs.getString(1),rs.getDate(2),rs.getDate(3),rs.getString(4),rs.getInt(5),rs.getString(6));
						
						System.out.println("成功");
					
					} else {
						
						System.out.println("失败");
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("报错了");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
		
	}
	
	
	public static ProbeStorageRes querProbeAttrNow(String probeAttId,Connection conn) { //查现这个ID最近建的
	//	 SELECT * FROM wifiprobedb.probestoragetable where probeAttributesTable_probeAttrId='ds' ORDER BY startTime DESC LIMIT 1 
		ProbeStorageRes u=null;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2 = "SELECT * FROM probestoragetable where probeAttributesTable_probeAttrId='"+probeAttId+"' ORDER BY startTime DESC LIMIT 1 ";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
					//ps.setString(1, probeStorageId);					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						
						u=new ProbeStorageRes(rs.getString(1),rs.getDate(2),rs.getDate(3),rs.getString(4),rs.getInt(5),rs.getString(6));
						
						System.out.println("成功");
					
					} else {
						
						System.out.println("失败");
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("报错了");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
		
	}  
	public static List<ProbeStorageRes> queryProbeAttrByProAttrId(String probeAttrId,Connection conn) {  // 查询探针属性ID
		List<ProbeStorageRes> list=new ArrayList<>();
		int i=0;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2 = "select * from probestoragetable as a where a.probeAttributesTable_probeAttrId='"+probeAttrId+"'";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
				//	ps.setString(1, username);					
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
					
						ProbeStorageRes us=new ProbeStorageRes(rs.getString(1),rs.getDate(2),rs.getDate(3),rs.getString(4),rs.getInt(5),rs.getString(6));
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
}
