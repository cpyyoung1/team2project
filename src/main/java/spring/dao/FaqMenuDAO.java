package spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.service.FaqMenuService;
import spring.vo.FaqMenuVO;
import spring.vo.FaqVO;

public class FaqMenuDAO
{
   private JdbcTemplate jdbcTemplate;

   public void setDataSource(DataSource dataSource)
   {
      this.jdbcTemplate = new JdbcTemplate(dataSource);
   }
   
   RowMapper<FaqMenuVO> rowMapper = // 형식수정
            new RowMapper<FaqMenuVO>() {
               @Override
               public FaqMenuVO mapRow(ResultSet rs, int rowNum) throws SQLException
               {
                     FaqMenuVO faqMenuVO = new FaqMenuVO(
                  rs.getString("faqMenuTitle")
                  );
            faqMenuVO.setFaqMenuNumber(rs.getInt("faqMenuNumber"));
            return faqMenuVO;
            }
      };
      
      public void insert(FaqMenuVO fmVO)
      {
         FaqMenuService faqMenuService = new FaqMenuService();
          faqMenuService.setFaqMenuVO(fmVO);
          
          int jdbc = jdbcTemplate.update(faqMenuService);
          System.out.println("쿼리성공"+jdbc);
      }
      
      public void delete(FaqMenuVO fmVO)
      {
         String sql = "DELETE FROM FAQMENU WHERE faqMenuNumber=?";
         jdbcTemplate.update(sql, fmVO.getFaqMenuNumber() );
      }
      
      public FaqMenuVO selectByfaqNumber(int faqMenuNumber)
      {
          String sql = "SELECT * FROM FAQMENU WHERE faqMenuNumber=?";
          List<FaqMenuVO> result = jdbcTemplate.query(sql,rowMapper,faqMenuNumber);
          return result.isEmpty()?null:result.get(0);
      }
      
      public List<FaqMenuVO> faqMenuList()
      {
         String sql = "SELECT * FROM FAQMENU ORDER BY faqMenuNumber";
         List<FaqMenuVO> result = jdbcTemplate.query(sql,rowMapper);
         return result;
      }
}