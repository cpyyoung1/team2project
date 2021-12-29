package spring.vo;

public class AuthInfo {//로그인 성공후 로그인 정보를 저장하기 위한 객체
   
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
   
   
   public AuthInfo(int memberNumber,String memberName,String memberId,String memberPw,String memberTel,String memberAddress
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


   public int getMemberNumber() {
      return memberNumber;
   }


   public String getMemberName() {
      return memberName;
   }


   public String getMemberId() {
      return memberId;
   }


   public String getMemberPw() {
      return memberPw;
   }


   public String getMemberTel() {
      return memberTel;
   }


   public String getMemberAddress() {
      return memberAddress;
   }


   public int getMemberGrade() {
      return memberGrade;
   }


   public String getMemberProfile() {
      return memberProfile;
   }


   public int getMemberPoint() {
      return memberPoint;
   }


   public String getMemberNickname() {
      return memberNickname;
   }

   
   
}