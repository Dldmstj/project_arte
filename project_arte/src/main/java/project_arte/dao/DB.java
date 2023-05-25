package project_arte.dao;

import java.sql.*;

public class DB {
	public static Connection conn() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc드라이버 예외" + e.getMessage());
		}
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(info,"scott","tiger");
		System.out.println("연결 성공!");
		return conn;
	}
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if(rs!=null) rs = null;		
		if(stmt!=null) stmt = null;		
		if(conn!=null) conn = null;
	}
}
