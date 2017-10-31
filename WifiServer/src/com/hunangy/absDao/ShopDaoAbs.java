package com.hunangy.absDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hunangy.DbRes.ShopRes;
import com.hunangy.DbRes.UserRes;

public abstract class ShopDaoAbs {
	public static boolean saveShop(ShopRes shop,Connection conn) { //店铺
		boolean x=false ;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2="INSERT INTO shoptable(shopId, shopName, shopAddr, shopRang, userTable_userAccount) VALUES (?,?,?,?,?)";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
					ps.setString(1, shop.getShopId());
					ps.setString(2, shop.getShopName());
					ps.setString(3, shop.getShopAddr());
					ps.setDouble(4, shop.getShopRang());
					ps.setString(5, shop.getUserTable_userAccount());
					
					System.out.println( shop.getShopId()+"   "+shop.getShopName()+"   "+shop.getShopAddr()+"  "+shop.getShopRang()+"  "+shop.getUserTable_userAccount());
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
	public static ShopRes queryShopById(String shopId,Connection conn) {  //通过店铺ID查询
		ShopRes u=null;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2 = "select * from shoptable where shopId=?";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
					ps.setString(1, shopId);					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						//System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
						u=new ShopRes(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
						
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
	public static List<ShopRes> queryShopByName(String shopName,Connection conn) { //通过店铺名查询
		List<ShopRes> list=new ArrayList<>();
		int i=0;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2 = "select * from shoptable where shopName='"+shopName+"'";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
					//ps.setString(1, shopName);					
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
					System.out.println(rs.getString(1)+"--------- "+rs.getString(2)+"--------- "+rs.getString(3));
					ShopRes us=new ShopRes(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
					list.add(us);

						System.out.println("成功"+i++);
					
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
