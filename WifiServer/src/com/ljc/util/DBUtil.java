package com.ljc.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


public class DBUtil {
	public static Connection conn = null;

	@Test
	public static Connection getConnet(String IP, int port, String Name) {

		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名scutcs
		String url = "jdbc:mysql://" + IP + ":" + port + "/" + Name + "";

		// String url = "jdbc:mysql://127.0.0.1:3306/wifiprobedb";

		// MySQL配置时的用户名
		String user = "root";

		// MySQL配置时的密码
		//String password = "cl737861753";
		String password="123456";

		try {
			Class.forName(driver);

			// 连续数据库
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("ok");
			} else {
				System.out.println("failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
