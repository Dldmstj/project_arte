package project_arte.vo;

public class Member {
	// 필드: 아이디, 비밀번호, 이름, 연락처, ...
	// ㄴ 예약폼에 필요한 정보(아이디, 이름, 연락처, 이메일)
	
	private String memberID;
	private String memName;
	private String memPhone;
	private String memEmail;
	
	// 생성자
	public Member() {}
	
	public Member(String memberID, String memName, String memPhone, String memEmail) {
		super();
		this.memberID = memberID;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memEmail = memEmail;
	}
	
	// getter, setter 함수
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
}
