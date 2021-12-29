package spring.vo;

public class FindPwCommand
{
   private String memberId;
   private String memberName;
   private String memberTel;
   
   public String getMemberId() {
      return memberId;
   }
   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }
   public String getMemberName() {
      return memberName;
   }
   public void setMemberName(String memberName) {
      this.memberName = memberName;
   }
   public String getMemberTel() {
      return memberTel;
   }
   public void setMemberTel(String memberTel) {
      this.memberTel = memberTel;
   }
   
   
}