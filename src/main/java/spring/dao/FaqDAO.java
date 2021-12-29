package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import spring.service.FaqService;
import spring.vo.FaqVO;
import spring.vo.Member;
import spring.vo.Message;


public class FaqDAO // 빈 추가**
{
      private JdbcTemplate jdbcTemplate;

      public void setDataSource(DataSource dataSource)
      {
         this.jdbcTemplate = new JdbcTemplate(dataSource);
      }
      
      
      private FaqVO qna;
      

	public void setQna(FaqVO qna) {
		this.qna = qna;
	}


	RowMapper<FaqVO> rowMapper = // 형식수정
               new RowMapper<FaqVO>() {
                  @Override
                  public FaqVO mapRow(ResultSet rs, int rowNum) throws SQLException
                  {
                        FaqVO faqVO = new FaqVO(
                     rs.getString("faqTitle"),
                     rs.getString("faqContent"),
                     rs.getInt("faqMenuNumber")
                     );
               faqVO.setFaqNumber(rs.getInt("faqNumber"));
               return faqVO;
               }
         };
         
         
         public void insert(FaqVO fVO)
         {
            FaqService faqService = new FaqService();
             faqService.setFaqVO(fVO);
             
             int jdbc = jdbcTemplate.update(faqService);
             System.out.println("쿼리성공"+jdbc);
         }
         
         public void update(FaqVO fVO)
         {
            String sql = "UPDATE FAQINNER set faqTitle=?, faqContent=?, faqMenuNumber=? WHERE faqNumber=?";
            jdbcTemplate.update(sql, fVO.getFaqTitle(), fVO.getFaqContent(), fVO.getFaqMenuNumber(), fVO.getFaqNumber() );
         }
         
         public void delete(FaqVO fVO)
         {
            String sql = "DELETE FROM FAQINNER WHERE faqNumber=?";
            jdbcTemplate.update(sql, fVO.getFaqNumber() );
         }
         
         public List<FaqVO> faqList()
         {
            String sql = "SELECT * FROM FAQINNER ORDER BY faqNumber DESC";
            List<FaqVO> result = jdbcTemplate.query(sql,rowMapper);
            return result;
         }
         
         public List<FaqVO> faqListByfaqMenuNumber(int faqMenuNumber)
         {
            String sql = "SELECT * FROM FAQINNER WHERE FAQMENUNUMBER=? ORDER BY faqNumber DESC";
            List<FaqVO> result = jdbcTemplate.query(sql,rowMapper,faqMenuNumber);
            return result;
         }
         
         public FaqVO selectByfaqNumber(int faqNumber)
         {
             String sql = "SELECT * FROM FAQINNER WHERE faqNumber=?";
             List<FaqVO> result = jdbcTemplate.query(sql,rowMapper,faqNumber);
             return result.isEmpty()?null:result.get(0);
         }
         
         public FaqVO selectByfaqMenuNumber(int faqMenuNumber)
         {
             String sql = "SELECT * FROM FAQINNER WHERE faqMenuNumber=?";
             List<FaqVO> result = jdbcTemplate.query(sql,rowMapper,faqMenuNumber);
             return result.isEmpty()?null:result.get(0);
         }
         
         
         
         
         

         
         
         
         //문의 게시판 글 등록
         public void insertQA(FaqVO qna) throws Exception{
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(
                  new PreparedStatementCreator() {
                     @Override
                     public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement psmt = con.prepareStatement(
                              //qnum, title, content,qtype, phone, regdate
                              "INSERT INTO questionboard  VALUES(SEQ_QUNUMBER.nextval,?,?,?,?,sysdate,?)", 
                              new String[] {"QUNUMBER"});
                        	psmt.setString(1, qna.getFaqTitle()); //제목
                        	psmt.setString(2, qna.getFaqContent()); //내용
                        	psmt.setInt(3, qna.getFaqMenuNumber()); //문의 유형
                        	psmt.setInt(4, qna.getFaqNumber()); //연락처
                        	psmt.setString(5, qna.getQid()); //아이디ㅡ
                        return psmt;
                     }
                  },keyHolder);
         

         }
         
         
         
         //모든 문의 내역 조회
         public List<FaqVO> qaList() throws Exception {
             List<FaqVO> results = jdbcTemplate.query(
                   "SELECT * FROM questionboard ORDER BY qunumber DESC" ,
                   new RowMapper<FaqVO>() {
                      @Override
                      public FaqVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                         FaqVO vo= new FaqVO(
                                    rs.getInt("QUNUMBER"),
                                    rs.getString("QUTITLE"),
                                    rs.getString("QUCONTENT"),
                                    rs.getInt("QUTYPE"),
                                    rs.getInt("MEMBERNUMBER"),
                         			rs.getDate("regDate"),
                         			rs.getString("id"));
                         		vo.setQaNum(rs.getInt("QUNUMBER"));
                         return vo;
                      }

                   });
             return results;
          }

         
     	//글번호로 찾기
  	   public FaqVO selectByQno(int qno)
  	   {
  	      String sql = "select * from questionboard where qunumber=?";
  	      List<FaqVO> result = jdbcTemplate.query(sql,new RowMapper<FaqVO>() {
  	         public FaqVO mapRow(ResultSet rs, int rowNum) throws SQLException{
  	            		FaqVO qa= new FaqVO(
                                rs.getInt("QUNUMBER"),
                                rs.getString("QUTITLE"),
                                rs.getString("QUCONTENT"),
                                rs.getInt("QUTYPE"),
                                rs.getInt("MEMBERNUMBER"),
                     			rs.getDate("regDate"),
                     			rs.getString("id"));
  	            		qa.setQaNum(rs.getInt("QUNUMBER"));
                     return qa;
  	         }
  	      },qno);
  	   
  	      
  	      return result.isEmpty()?null:result.get(0);

  	   }
  	   
  	   //삭제
  	   public void selectDelete(FaqVO qno)
  	   {
  	      jdbcTemplate.update(
  	            "DELETE FROM questionboard WHERE qunumber=?",
  	            qno.getQaNum()
  	            );
  	   } 
  	   

  		RowMapper<Member> map =
  				new RowMapper<Member>() {
  			@Override
  			public Member mapRow(ResultSet rs, int rowNum) throws SQLException
  			{
  				Member member = new Member(
  						rs.getInt("memberNumber"),
  						rs.getString("memberName"),
  						rs.getString("memberId"),
  						rs.getString("memberPw"),
  						rs.getString("memberTel"),
  						rs.getString("memberAddress"),
  						rs.getInt("memberGrade"),
  						rs.getString("memberProfile"),
  						rs.getInt("memberPoint"),
  						rs.getString("memberNickname")
  						);
  				member.setMemberNumber(rs.getInt("memberNumber"));
  				return member;
  			}
  		}; 
  		
        
        
        //연락처 유효성 검사
        public Member chkTel(int num)
        {
       	 String sql = "select from member where membertel=?";
       	 List<Member> result = jdbcTemplate.query(sql,map,num);
    		return result.isEmpty()?null:result.get(0);
        }
        
}