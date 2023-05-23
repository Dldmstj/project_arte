package project_arte.vo;

public class Museum {
	// 필드: 지점명, 날짜
	
	private String musId;
	private String loc;
	private String date;
	
	// 생성자
	public Museum() {}
	
	public Museum(String loc, String date) {
		this.loc = loc;
		this.date = date;
	}
	public Museum(String musId, String loc, String date) {
		this.musId = musId;
		this.loc = loc;
		this.date = date;
	}
	
	// getter, setter
	public String getMusId() {
		return musId;
	}
	public void setMusId(String musId) {
		this.musId = musId;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
