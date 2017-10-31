package com.hunangy.absDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.hunangy.DbRes.UserRes;
import com.ljc.util.DBUtil;

public class UserDaoAbs {
//	@Test
//	public void Testdao() throws SQLException {
//		 String IP = "127.0.0.1";
//		 int port = 3306;
//		 String name = "wifiprobedb";
//		Connection conn = DBUtil.getConnet(IP, port, name);
//		UserRes userRes=new UserRes("2","456","457");
//		if (UpDataUser(userRes, conn)) {
//			System.out.println("成功");
//		}else System.out.println("失败");
//		
//		conn.close();
//	}
	
	public static boolean saveUser(UserRes user,Connection conn) {   //保存用户
		boolean x=false ;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2="insert into usertable(userAccount, username, passworld) values(?,?,?)";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
					ps.setString(1, user.getUserAccount());
					ps.setString(2, user.getUsername());
					ps.setString(3, user.getPassword());
					
					System.out.println(user.getUserAccount()+"   "+user.getUsername()+"   "+user.getPassword());
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
	
	
	
	public static boolean UpDataUser(UserRes user,Connection conn){
		boolean x=false ;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2="UPDATE usertable SET username=?, passworld=? WHERE userAccount=?";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
					
					ps.setString(1, user.getUsername());
					ps.setString(2, user.getPassword());
					ps.setString(3, user.getUserAccount());
					System.out.println(user.getUserAccount()+"   "+user.getUsername()+"   "+user.getPassword());
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
	//UPDATE wifiprobedb.usertable SET username='3', passworld='4' WHERE userAccount='2';
	
	
	public static UserRes queryUserByAccount(String Account,Connection conn) { //按帐号查询用户
		
		UserRes u=null;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2 = "select * from usertable where userAccount=?";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
					ps.setString(1, Account);					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						//System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
						u=new UserRes(rs.getString(1),rs.getString(2),rs.getString(3));
						
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
	public static List<UserRes> queryUserByName(String username,Connection conn) {  //按用户名查询用户
		
		List<UserRes> list=new ArrayList<>();
		int i=0;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2 = "select * from usertable where username='"+username+"'";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
				//	ps.setString(1, username);					
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
					//System.out.println(rs.getString(1)+"--------- "+rs.getString(2)+"--------- "+rs.getString(3));
					UserRes us=new UserRes(rs.getString(1),rs.getString(2),rs.getString(3));
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
	
	
	
	
	
	
public static List<UserRes> queryUserBy(String account,Connection conn) {  //用户登录查询
		
		List<UserRes> list=new ArrayList<>();
		int i=0;
		try {
			
			if (conn != null) {
				try {
					
					String sql_query2 = "select b.userAccount,b.username,b.passworld,a.probeAttrId,a.rate from probeattributestable as a, usertable as b where b.userAccount='"+account+"' and a.userTable_userAccount=b.userAccount";				
					PreparedStatement ps = conn.prepareStatement(sql_query2);					
				//	ps.setString(1, username);					
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
				//	System.out.println(rs.getString(1)+"--------- "+rs.getString(2)+"--------- "+rs.getString(3),rs.getString(4),rs.getInt(5));
					UserRes us=new UserRes(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
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
