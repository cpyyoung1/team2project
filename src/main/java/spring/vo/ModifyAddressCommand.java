package spring.vo;

public class ModifyAddressCommand
{
   String memberId;
   String memberAddress;
   
   public String getMemberId() {
      return memberId;
   }
   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }
   public String getMemberAddress() {
      return memberAddress;
   }
   public void setMemberAddress(String memberAddress) {
      this.memberAddress = memberAddress;
   }
   
   
}