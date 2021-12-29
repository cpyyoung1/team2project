package spring.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

import spring.vo.NoticeVO;

public class NoticeService implements PreparedStatementCreator
{
   
   private NoticeVO noticeVO;

   public NoticeVO getNoticeVO() {
      return noticeVO;
   }

   public void setNoticeVO(NoticeVO noticeVO) {
      this.noticeVO = noticeVO;
   }

   @Override
   public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
      System.out.println("성공" + noticeVO.getNoticeTitle() );
      PreparedStatement psmt = con.prepareStatement(
            "INSERT INTO NOTICE VALUES(seq_noticenumber.NEXTVAL, ?, ?, SYSDATE)");
      psmt.setString(1,noticeVO.getNoticeTitle() );
      psmt.setString(2,noticeVO.getNoticeContent() );
      return psmt;
   }
}