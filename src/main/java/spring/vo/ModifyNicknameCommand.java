package spring.vo;

public class ModifyNicknameCommand
{
   String memberId;
   String memberNickname;
   
   public String getMemberId() {
      return memberId;
   }
   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }
   public String getMemberNickname() {
      return memberNickname;
   }
   public void setMemberNickname(String memberNickname) {
      this.memberNickname = memberNickname;
   }
}