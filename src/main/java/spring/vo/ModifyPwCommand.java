package spring.vo;

public class ModifyPwCommand {
   
   private String memberId;
   private String currentPassword;
   private String newPassword;
   private String confirmPassword;
   
   public String getMemberId() {
      return memberId;
   }
   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }
   public String getCurrentPassword() {
      return currentPassword;
   }
   public void setCurrentPassword(String currentPassword) {
      this.currentPassword = currentPassword;
   }
   public String getNewPassword() {
      return newPassword;
   }
   public void setNewPassword(String newPassword) {
      this.newPassword = newPassword;
   }
   public String getConfirmPassword() {
      return confirmPassword;
   }
   public void setConfirmPassword(String confirmPassword) {
      this.confirmPassword = confirmPassword;
   }
   
   
}