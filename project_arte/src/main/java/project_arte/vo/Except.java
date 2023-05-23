package project_arte.vo;

public class Except extends Exception {

}
class PersonalExp extends Exception{		// 개인정보 이용 약관에 동의하지 않으면 발생하는 예외
	PersonalExp(){
		super("개인정보이용 약관에 동의하지 않으면 예약을 진행할 수 없습니다.");
	}
	public String getMessage() {
		String errMsg = super.getMessage();
		return errMsg;
		
	}
}

class NoticeExp extends Exception{			// 유의사항 확인에 체크하지 않으면 발생하는 예외
	NoticeExp(){
		super("유의사항을 확인하지 않으면 예약을 진행할 수 없습니다.");
	}
	public String getMessage() {
		String errMsg = super.getMessage();
		return errMsg;
		
	}
}