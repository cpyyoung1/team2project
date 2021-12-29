package spring.vo;

import java.util.Date;

public class BoardVO {
   
   /*
    bno number PRIMARY KEY,
    title varchar2 not null,
    content varchar2 not null,
    memberNum number,
    regDate date default sysdate,
    viewCnt number default 0
    */
   
   private int bno;      //게시물번호
   private String title;   //제목
   private String content;   //내용
   private String id;   //회원아이디
   private Date regDate;   //작성일
   private int viewCnt;   //조회수
   
   
   //생성자 
   public BoardVO() {
      
   }
   
   public BoardVO(int bno, String title, String content,Date regDate, int viewCnt,String id) {
      this.bno = bno;
      this.title = title;
      this.content = content;
      this.regDate = regDate;
      this.viewCnt = viewCnt;
      this.id = id;
   }
   
   
   
   //Getter, Setter
   public int getBno() {
      return bno;
   }
   
   public void setBno(int bno) {
      this.bno = bno;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
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

   public void setId(String id) {
      this.id = id;
   }

   public Date getRegDate() {
      return regDate;
   }
   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }
   public int getViewCnt() {
      return viewCnt;
   }
   public void setViewCnt(int viewCnt) {
      this.viewCnt = viewCnt;
   }

   
   
   
   
   
}