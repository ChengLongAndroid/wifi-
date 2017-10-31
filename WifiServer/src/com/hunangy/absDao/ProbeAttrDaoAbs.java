package com.hunangy.absDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hunangy.DbRes.ProbeAttrRes;
import com.hunangy.DbRes.UserRes;

public abstract class ProbeAttrDaoAbs {
	
	public static boolean saveProbeAttr(ProbeAttrRes shop, Connection conn) { // 保存探针属性
		boolean x = false;
		try {

			if (conn != null) {
				try {

					String sql_query2 = "INSERT INTO probeattributestable (probeAttrId, mmac, rate, lat, lon, probeAddr, userTable_userAccount, shopTable_shopId) VALUES (?,?,?,?,?,?,?,?)";
					PreparedStatement ps = conn.prepareStatement(sql_query2);
					ps.setString(1, shop.getProbeAttrId());
					ps.setString(2, shop.getMmac());
					ps.setInt(3, shop.getRate());
					ps.setDouble(4, shop.getLat());
					ps.setDouble(5, shop.getLon());
					ps.setString(6, shop.getProbeAddr());
					ps.setString(7, shop.getUserTable_userAccount());
					ps.setString(8, shop.getShopTable_shopId());

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

	public static ProbeAttrRes queryProbeAttrById(String probeAttrId,Connection conn) { // 通过ID查
		ProbeAttrRes u = null;
		try {

			if (conn != null) {
				try {

					String sql_query2 = "SELECT * FROM probeattributestable where probeAttrId='"+ probeAttrId + "'";
					PreparedStatement ps = conn.prepareStatement(sql_query2);
					// ps.setString(1, probeAttrId);
					ResultSet rs = ps.executeQuery();

					if (rs.next()) {

						u = new ProbeAttrRes(rs.getString(1), rs.getString(2),
								rs.getInt(3), rs.getDouble(4), rs.getDouble(5),
								rs.getString(6), rs.getString(7),
								rs.getString(7));

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

	public static List<ProbeAttrRes> queryProbeAttrByShopId(String shopId,Connection conn) { // 通过店铺查
		//select * from probeattributestable as a,shoptable as b where b.shopId='66'
		List<ProbeAttrRes> list=new ArrayList<>();
		int i=0;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2 = "select * from probeattributestable as a,shoptable as b where b.shopId='"+shopId+"'";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
				//	ps.setString(1, username);					
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
					
					ProbeAttrRes us=new ProbeAttrRes(rs.getString(1), rs.getString(2),
							rs.getInt(3), rs.getDouble(4), rs.getDouble(5),
							rs.getString(6), rs.getString(7),
							rs.getString(7));
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

	public static List<ProbeAttrRes> queryProbeAttrByUserAccount(String userAccount, Connection conn) { // 通过用户账户查
		List<ProbeAttrRes> list=new ArrayList<>();
		int i=0;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2 = "select * from probeattributestable as a,usertable as b where b.userAccount='"+userAccount+"'";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
				//	ps.setString(1, username);					
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
					
					ProbeAttrRes us=new ProbeAttrRes(rs.getString(1), rs.getString(2),
							rs.getInt(3), rs.getDouble(4), rs.getDouble(5),
							rs.getString(6), rs.getString(7),
							rs.getString(7));
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







