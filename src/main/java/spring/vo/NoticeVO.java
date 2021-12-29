package spring.vo;

import java.util.Date;

public class NoticeVO
{
   private int noticeNumber;
   private String noticeTitle;
   private String noticeContent;
   private Date noticeDate;
   
   public NoticeVO(){};
   
   public NoticeVO(String noticeTitle, String noticeContent, Date noticeDate)
   {
      this.noticeTitle = noticeTitle;
      this.noticeContent = noticeContent;
      this.noticeDate = noticeDate;
   }
   
   public void modify(String newTitle, String newContent)
   {
      this.noticeTitle = newTitle;
      this.noticeContent = newContent;
   }

   public int getNoticeNumber() {
      return noticeNumber;
   }

   public void setNoticeNumber(int noticeNumber) {
      this.noticeNumber = noticeNumber;
   }

   public String getNoticeTitle() {
      return noticeTitle;
   }

   public void setNoticeTitle(String noticeTitle) {
      this.noticeTitle = noticeTitle;
   }

   public String getNoticeContent() {
      return noticeContent;
   }

   public void setNoticeContent(String noticeContent) {
      this.noticeContent = noticeContent;
   }

   public Date getNoticeDate() {
      return noticeDate;
   }

   public void setNoticeDate(Date noticeDate) {
      this.noticeDate = noticeDate;
   }
}