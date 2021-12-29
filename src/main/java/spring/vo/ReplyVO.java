package spring.vo;

import java.util.Date;

public class ReplyVO {
/*  
    no       number            not null,
    content   varchar2(2000)    not null,
    writer    varchar2(30)      not null,
    regDate   date              default sysdate,
*/
   private int bno;
   private int no;   //덧글번호
   private String content; //덧글내용
   private String id;   //작성자
   private Date regDate;   //작성일
   

      public ReplyVO() {
         
      }
      public ReplyVO(int bno ,int no,String content, String id,Date regDate) {
         this.bno = bno;
         this.no = no;
         this.content = content;
         this.id = id;
         this.regDate = regDate;
      }
   
   
   public int getBno() {
      return bno;
   }
   public void setBno(int bno) {
      this.bno = bno;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public String getId() {
      return id;
   }
   public int getNo() {
      return no;
   }
   public void setNo(int no) {
      this.no = no;
   }
   public void setId(String id) {
      this.id = id;
   }
   public Date getRegDate() {
      return regDate;
   }
   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }
   
   
   
}