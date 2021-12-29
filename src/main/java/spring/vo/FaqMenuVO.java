package spring.vo;

public class FaqMenuVO
{
   private int faqMenuNumber;
   private String faqMenuTitle;
   
   public FaqMenuVO(){};
   
   public FaqMenuVO(String faqMenuTitle)
   {
      this.faqMenuTitle = faqMenuTitle;
   }
   
   public int getFaqMenuNumber() {
      return faqMenuNumber;
   }
   public void setFaqMenuNumber(int faqMenuNumber) {
      this.faqMenuNumber = faqMenuNumber;
   }
   public String getFaqMenuTitle() {
      return faqMenuTitle;
   }
   public void setFaqMenuTitle(String faqMenuTitle) {
      this.faqMenuTitle = faqMenuTitle;
   }
}