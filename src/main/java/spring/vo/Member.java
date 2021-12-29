package spring.vo;

import java.util.Date;

import spring.exception.IdPasswordNotMatchingException;

public class Member {
	private int memberNumber;
	private String memberName;
	private String memberId;
	private String memberPw;
	private String memberTel;
	private String memberAddress;
	private int memberGrade;
	private String memberProfile;
	private int memberPoint;
	private String memberNickname;
	
	
	public Member(int memberNumber,String memberName,String memberId,String memberPw,String memberTel,String memberAddress
		,int memberGrade,String memberProfile,int memberPoint,String memberNickname) {
		
		this.memberNumber=memberNumber;
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberTel = memberTel;
		this.memberAddress = memberAddress;
		this.memberGrade = memberGrade;
		this.memberProfile = memberProfile;
		this.memberPoint = memberPoint;
		this.memberNickname = memberNickname;
		}
	
	public Member(String memberId , String memberPw) {
		this.memberId = memberId;
		this.memberPw = memberPw;

		
	}
	
	public boolean matchPassword(String inputPassword) {
		return this.memberPw.equals(inputPassword);
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!memberPw.equals(oldPassword))
			throw new IdPasswordNotMatchingException();
		this.memberPw = newPassword;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

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

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public String getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}

	public int getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}
	public String getMemberNickname() {
		// TODO Auto-generated method stub
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	
}
