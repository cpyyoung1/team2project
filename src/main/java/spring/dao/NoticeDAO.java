package spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.service.NoticeService;
import spring.vo.BoardVO;
import spring.vo.Member;
import spring.vo.NoticeVO;
import spring.vo.Product;

public class NoticeDAO
{
   private JdbcTemplate jdbcTemplate;

   public void setDataSource(DataSource dataSource) {
      this.jdbcTemplate = new JdbcTemplate(dataSource);
   }
   
   RowMapper<NoticeVO> rowMapper =
            new RowMapper<NoticeVO>() {
               @Override
               public NoticeVO mapRow(ResultSet rs, int rowNum) throws SQLException
               {
                  NoticeVO noticeVO = new NoticeVO(
                  rs.getString("noticeTitle"),
                  rs.getString("noticeContent"),
                  rs.getDate("noticeDate")
                  );
            noticeVO.setNoticeNumber(rs.getInt("noticeNumber"));
            return noticeVO;
            }
      };
   
   public void insert(NoticeVO nVO)
   {
      NoticeService noticeService = new NoticeService();
      noticeService.setNoticeVO(nVO);
      
      int jdbc = jdbcTemplate.update(noticeService);
      System.out.println("쿼리성공"+jdbc);
   }
   
   public void update(NoticeVO nVO)
   {
      String sql = "UPDATE notice set noticeTitle=?, noticeContent=?, noticeDate=? WHERE noticeNumber=?";
      jdbcTemplate.update(sql, nVO.getNoticeTitle(), nVO.getNoticeContent(), new Date(), nVO.getNoticeNumber() );
   }
   
   public void delete(NoticeVO nVO)
   {
      String sql = "DELETE FROM notice WHERE noticeNumber=?";
      
      jdbcTemplate.update(sql, nVO.getNoticeNumber() );
   }
   
   public List<NoticeVO> noticeList()
   {
      String sql = "SELECT * FROM notice ORDER BY noticeNumber DESC";
      List<NoticeVO> result = jdbcTemplate.query(sql,rowMapper);      
      return result;
   }
   
   public NoticeVO selectBynoticeNumber(int noticeNumber)
   {
       String sql = "SELECT * FROM notice WHERE noticeNumber=?";
       List<NoticeVO> result = jdbcTemplate.query(sql,rowMapper,noticeNumber);
       return result.isEmpty()?null:result.get(0);
   }
}