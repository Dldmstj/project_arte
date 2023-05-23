package project_arte.dao;

import java.sql.*;

public class DB {
	public static Connection conn() throws SQLException {
		Connection conn = null;
		// 1. 메모리 로딩(ClassNotFoundException 처리)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc드라이버 예외" + e.getMessage());
		}
		// 2. 연결 정보 처리(Connection) DB처리를 포함해서  그 외 예외를 처리하기 위해 예외를 위임한다.
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(info,"scott","tiger");
		System.out.println("연결 성공!");
		return conn;
	}
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		// rs.close(), stmt.close(), con.close()
		// api에 지원하는 안정적인 자원해제 방법
		// rs.close()에 의하거나, 다른 예외로 예외가 나왔을 때는 아래에 내용을 강제 자원해제 한다.
		// 남은 자원해제시 처리하는 부분
		if(rs!=null) rs = null;		
		if(stmt!=null) stmt = null;		
		if(conn!=null) conn = null;
	}
}
