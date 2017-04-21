package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * jdbc 工具类，提供了获得连接与关闭连接的操作
 *
 */
public class DBUtil {
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/python?useUnicode=true&characterEncoding=UTF-8",
					"root","");*/
			conn = DriverManager.getConnection(
					"jdbc:mysql://?useUnicode=true&characterEncoding=UTF-8",
					"sodasoccer","123456789");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return conn;
	}
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Connection conn = getConnection();
		System.out.println(conn);
	}

}
