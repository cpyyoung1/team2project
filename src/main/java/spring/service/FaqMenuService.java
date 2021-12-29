package spring.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

import spring.vo.FaqMenuVO;

public class FaqMenuService implements PreparedStatementCreator
{
   private FaqMenuVO faqMenuVO;

   public FaqMenuVO getFaqMenuVO()
   {
      return faqMenuVO;
   }

   public void setFaqMenuVO(FaqMenuVO faqMenuVO)
   {
      this.faqMenuVO = faqMenuVO;
   }

      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
         System.out.println("성공" + faqMenuVO.getFaqMenuTitle() );
         PreparedStatement psmt = con.prepareStatement(
               "INSERT INTO FAQMENU VALUES(seq_faqmenunumber.NEXTVAL, ?)");
         psmt.setString(1,faqMenuVO.getFaqMenuTitle() );
         return psmt;
      } 
}