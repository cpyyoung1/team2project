package spring.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

import spring.vo.FaqVO;

public class FaqService implements PreparedStatementCreator
{
   private FaqVO faqVO;

   public FaqVO getFaqVO()
   {
      return faqVO;
   }

   public void setFaqVO(FaqVO faqVO)
   {
      this.faqVO = faqVO;
   }

      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
         System.out.println("성공" + faqVO.getFaqTitle() );
         PreparedStatement psmt = con.prepareStatement(
               "INSERT INTO FAQINNER VALUES(seq_faqnumber.NEXTVAL, ?, ?, ?)");
         psmt.setString(1,faqVO.getFaqTitle() );
         psmt.setString(2,faqVO.getFaqContent() );
         psmt.setInt(3,faqVO.getFaqMenuNumber() );
         return psmt;
      }
}