package project_arte.vo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Reservation {
	// 필드 : 예약자정보(아이디, 이름, 연락처, 이메일) 방문자 연락처, 인원, 나이, (지점명, 날짜), 입장료
	// 메서드: 개인정보이용동의 여부, 유의사항 확인 여부, 예약하기, 나이별 입장료 계산, 총금액 계산
	
	private Member member;
	private Museum museum;
	// 방문자 정보
	private String resName;
	private String resPhone;
	private int totCnt;		// 총 인원 수
	private int totPrice;		// 입장료 총 금액
	
	// 입장료
	private final int childPrice = 10000;
	private final int teenPrice = 13000;
	private final int adultPrice = 17000;
	
	private boolean personalCheck;	// 개인정보 이용동의
	private boolean noticeCheck;	// 유의사항 확인 여부
	
	private String resNum;	// 예약번호
	
	// 생성자
	public Reservation() {}
	
	public Reservation(Member member, Museum museum, String resName, String resPhone, int totCnt,
			int totPrice, boolean personalCheck, boolean noticeCheck) {
		this.member = member;
		this.museum = museum;
		this.resName = resName;
		this.resPhone = resPhone;
		this.totCnt = totCnt;
		this.totPrice = totPrice;
		this.personalCheck = personalCheck;
		this.noticeCheck = noticeCheck;
	}

	// 사용자 정의 메서드
	public void reservate() {	// 예약 메소드
		inputVisitor();		// 방문자 정보 입력 메서드
		System.out.println("총 입장료: " + totAmount() +"원");		// 총 입장료 계산
		personalCheck();		// 개인정보 이용 동의 여부
		noticeCheck();			// 유의사항 확인 여부
		confirmRes();		// 예약 확정 여부
	}
	
	public void inputVisitor() {	// 방문자 정보 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("방문자명 입력: ");
		this.resName = sc.nextLine();
		System.out.print("방문자 연락처 입력: ");
		this.resPhone = sc.nextLine();
	}
	
	public int totAmount() {	// 청소년 몇명인지 입력, 소인 입력, 성인 입력 -> 총 금액 return하는 메서드
//		java.util.InputMismatchException 처리(숫자형 입력이 아닐 경우)
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("소인 입력: ");
			int childCnt = sc.nextInt();
			System.out.print("청소년 입력: ");
			int teenCnt = sc.nextInt();
			System.out.print("성인 입력: ");
			int adultCnt = sc.nextInt();
			this.totCnt =  childCnt + teenCnt +adultCnt;	// 총 인원수
			int totPrice = childCnt*childPrice + teenCnt * teenPrice + adultCnt * adultPrice;
			this.totPrice = totPrice;

		}catch(InputMismatchException e){
			System.out.println("숫자형으로 입력해주세요.");
			totAmount();
		}
		return totPrice;
	}
	
	public boolean personalCheck() {	// 개인정보 이용약관 동의 체크
		Scanner sc = new Scanner(System.in);
		System.out.println("개인정보이용 약관에 동의하십니까? (예/아니오)");
		String personalAns = sc.nextLine();
		try {
			if(!personalAns.equals("예")) {
				throw new PersonalExp();
			}
		}catch(PersonalExp e) {
			System.out.println(e.getMessage());
			personalCheck();
		}
		this.personalCheck = true;
		return this.personalCheck;
	}
	
	public boolean noticeCheck() {		// 유의사항 확인 여부 체크
		Scanner sc = new Scanner(System.in);
		System.out.println("유의사항을 확인하셨습니까? (예/아니오)");
		String noticeAns = sc.nextLine();
		try {
			if(!noticeAns.equals("예")) {
				throw new NoticeExp();
			}
		}catch(NoticeExp e) {
			System.out.println(e.getMessage());
			noticeCheck();
		}
		this.noticeCheck = true;
		return this.noticeCheck;
	}
	
	public void makeResNum() {		// 랜덤 번호 생성으로 예약번호 랜덤 생성
		char[] arr = new char[10];
		for(int idx=0; idx<arr.length; idx++) {
			int ranNum = (int)(Math.random() * 62 + 48);	// ranNum 48~116
			if(ranNum>57)	ranNum +=7;	// 49~57, 58~64 => A
			if(ranNum>90)	ranNum +=6;	// 49~57, 58~64 => A
			arr[idx] = (char)ranNum;
		}
		String resNum = new String(arr);
		this.resNum = resNum;
	}
	
	public void confirmRes() {	// 예약 확정여부
		Scanner sc = new Scanner(System.in);
		System.out.println("예약하시겠습니까? (예/아니오)");
		String confirmAns = sc.nextLine();
		if(confirmAns.equals("예")) {
			makeResNum();		// 랜덤 예약번호 생성
			showResInfo();		// 예약 확정 되면 예약 정보 출력
			}else{
				System.out.println("예약을 취소하셨습니다.");
			}
	}
	
	public void showResInfo() {		// 예약 정보 출력
		System.out.println();
		System.out.println("--------- 예약 정보 ---------");
		System.out.println("예약번호: "+ resNum);
		System.out.println("예약된 지점명: "+ museum.getLoc());
		System.out.println("예약된 날짜명: "+ museum.getDate());
		System.out.println("----예약자 정보----");
		System.out.println("예약자아이디: "+member.getMemberID());
		System.out.println("예약자명: "+member.getMemName());
		System.out.println("예약자연락처: "+member.getMemPhone());
		System.out.println("예약자이메일: "+member.getMemEmail());
		System.out.println("----방문자 정보----");
		System.out.println("방문자 이름: "+resName);
		System.out.println("방문자 연락처: "+resPhone);
		System.out.println("방문할 총 인원 수: "+totCnt);
		System.out.println("개인정보 이용 동의 여부: "+personalCheck);
		System.out.println("유의사항 확인 여부: "+noticeCheck);
		System.out.println("총 결제 금액: "+totPrice+"원");
	}

	// getter, setter
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Museum getMuseum() {
		return museum;
	}
	public void setMuseum(Museum museum) {
		this.museum = museum;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResPhone() {
		return resPhone;
	}
	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}
	public int getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}
	public int getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(int totPrice) {
		this.totPrice = totPrice;
	}
	public boolean isPersonalCheck() {
		return personalCheck;
	}
	public void setPersonalCheck(boolean personalCheck) {
		this.personalCheck = personalCheck;
	}
	public boolean isNoticeCheck() {
		return noticeCheck;
	}
	public void setNoticeCheck(boolean noticeCheck) {
		this.noticeCheck = noticeCheck;
	}
	public String getResNum() {
		return resNum;
	}
	public void setResNum(String resNum) {
		this.resNum = resNum;
	}
}
