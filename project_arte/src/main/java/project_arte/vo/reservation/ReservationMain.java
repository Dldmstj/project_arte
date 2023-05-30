package project_arte.vo.reservation;

import project_arte.dao.ReservationDao;

public class ReservationMain {

	public static void main(String[] args) {
		Reservation rv = new Reservation();
		Member mem = new Member("sh1n", "짱구", "01012341234", "xx@xx.com");		
			// 로그인 했다는 가정 하에 로그인된 사용자(Member) 객체
		Museum ms = new Museum("제주", "2023-05-14");			// 지점(Museum) 객체
		rv.setMember(mem);
		rv.setMuseum(ms);
		rv.reservate(mem,ms,rv);
		
//		ReservationDao rdao = new ReservationDao();
//		rdao.insertReservation(mem,ms,rv);
		
		
	}

}
