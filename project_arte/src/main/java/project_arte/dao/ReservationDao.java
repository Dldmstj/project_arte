package project_arte.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import project_arte.vo.Member;
import project_arte.vo.Museum;
import project_arte.vo.Reservation;

public class ReservationDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	// 예약 진행 메서드
	public void insertReservation(Member mem, Museum mus, Reservation res) {
		int isInsert = 0;
//		mem = res.getMember();
//		mus = res.getMuseum();
		String sql ="insert into reservations"
				+ "(resNum,loc,can_date,memId,memName, "
				+ "memPhone,memEmail,resName,resPhone,"
				+ "totCnt, totPrice, resTime) values(?,?,to_date(?,'YYYY-MM-DD'),?,?,?,?,?,?,?,?,sysdate)";
		try {
			conn = DB.conn();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, res.getResNum());
			pstmt.setString(2, mus.getLoc());
			pstmt.setString(3, mus.getDate());
			pstmt.setString(4, mem.getMemberID());
			pstmt.setString(5, mem.getMemName());
			pstmt.setString(6, mem.getMemPhone());
			pstmt.setString(7, mem.getMemEmail());
			pstmt.setString(8, res.getResName());
			pstmt.setString(9, res.getResPhone());
			pstmt.setInt(10, res.getTotCnt());
			pstmt.setInt(11, res.getTotPrice());
			
			isInsert = pstmt.executeUpdate();
			
			conn.commit();
			if(isInsert == 1 )System.out.println("등록 성공");
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("DB예외: " + e.getMessage());
			try {
				conn.rollback();	// 예외 발생시 rollback
			} catch (SQLException e1) {
				System.out.println("rollback예외: " + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타예외: " + e.getMessage());
		}finally {
			DB.close(rs, pstmt, conn);
		}
	}

	

}
