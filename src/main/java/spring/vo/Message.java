package spring.vo;

import java.util.Date;

public class Message {

   
   
   private String sender;      //보낸 ID
   private String reciver;      //받는 ID
   private String content;      //내용
   private Date regdate;         //보낸날짜
   private int mno;         //쪽지번호 
   

   
   //기본생성자
   public Message() {
      super();
   }



   public Message(String sender, String content, Date date, int mno , String reciver) {
      this.sender = sender;
      this.reciver = reciver;
      this.content = content;
      this.regdate = date;
      this.mno = mno;
   }



   public String getSender() {
      return sender;
   }



   public void setSender(String sender) {
      this.sender = sender;
   }



   public String getReciver() {
      return reciver;
   }



   public void setReciver(String reciver) {
      this.reciver = reciver;
   }



   public String getContent() {
      return content;
   }



   public void setContent(String content) {
      this.content = content;
   }



   public Date getRegdate() {
      return regdate;
   }



   public void setRegdate(Date regdate) {
      this.regdate = regdate;
   }



   public int getMno() {
      return mno;
   }



   public void setMno(int mno) {
      this.mno = mno;
   }
   
   
   





   
   
   
   
   
   
}