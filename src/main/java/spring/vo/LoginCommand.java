package spring.vo;

public class LoginCommand {// 사용자로 부터 정보를 가져오는 커맨드 객체
	
	private String memberId;
	private String memberPw;
	private boolean remembermemberId;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public boolean isRemembermemberId() {
		return remembermemberId;
	}
	public void setRemembermemberId(boolean remembermemberId) {
		this.remembermemberId = remembermemberId;
	}
	
	
}
