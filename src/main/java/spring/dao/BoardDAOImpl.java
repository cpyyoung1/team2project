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

import spring.vo.BoardVO;
import spring.vo.Member;
import spring.vo.ReplyVO;



public class BoardDAOImpl implements BoardDAO{

   private JdbcTemplate jdbcTemplate;  // Templatate

   private BoardVO board;
   private Member member;   

   public BoardVO getBoard() {
      return board;
   }


   public void setBoard(BoardVO board) {
      this.board = board;
   }


   public Member getMember() {
      return member;
   }


   public void setMember(Member member) {
      this.member = member;
   }
   
   RowMapper<BoardVO> rowMapper =
         new RowMapper<BoardVO>() {      
       @Override
       public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {   
          BoardVO BoardVO = new BoardVO(
                rs.getInt("bno"),
                rs.getString("Title"),
                rs.getString("Content"),
                rs.getDate("regdate"),
                rs.getInt("viewcnt"),
                rs.getString("Id")
                );
          BoardVO.setBno(rs.getInt("bno"));
          return BoardVO;
       }
    };


   //Set메소드 주입
   public void setDataSource(DataSource dataSource) {
      this.jdbcTemplate = new JdbcTemplate(dataSource);
   }

//      jdbcTemplate.update(
//            "UPDATE board SET title=?,content=? WHERE bno=?;" ,
//            boardvo.getTitle(),
//            boardvo.getContent(),
//            boardvo.getBno()
//            );
      

   

   
   
//   //글 수정하기
//   @Override
//   public void update(BoardVO vo) throws Exception {
//      jdbcTemplate.update(
//            "UPDATE board SET title=?,content=? WHERE bno=?;" ,
//            board.getTitle(),
//            board.getContent(),
//            board.getBno()
//            );
//   }
   
   //글 작성
   @Override
   public void write(BoardVO vo) throws Exception {

      KeyHolder keyHolder = new GeneratedKeyHolder();

      jdbcTemplate.update(// update(PreparedStatementCreator객체,keyHolder);
            new PreparedStatementCreator() {

               @Override
               public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                  PreparedStatement psmt = con.prepareStatement(
                        "INSERT INTO board VALUES(bno_seq.NEXTVAL,?,?,sysdate,0,?)", 
                        new String[] {"bno"});
                  //SQL INSERT bno, title, content, id, regDate, viewCnt;
                  psmt.setString(1,vo.getTitle() ); //title
                  psmt.setString(2,vo.getContent());   //content
                  psmt.setString(3,vo.getId());   //id
                  //                  System.out.println(board.getId());
                  //                  System.out.println(board.getTitle());
                  //                  System.out.println(board.getContent());


                  //                  System.out.println(board.getRegDate());
                  //                  System.out.println(member.getMemberId());
                  //                  System.out.println(board.getBno()+board.getTitle()+board.getRegDate()); //생성 번호, 제목, 작성일 출력
                  return psmt;
               }
            },keyHolder);
   }
   @Override
   public void writeReply(ReplyVO vo) throws Exception {

      System.out.println("writeReply"+vo);

      jdbcTemplate.update(// update(PreparedStatementCreator객체,keyHolder);
            new PreparedStatementCreator() {

               @Override
               public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                  PreparedStatement psmt = con.prepareStatement(
                        "INSERT INTO reply VALUES(?,REPLY_SEQ.NEXTVAL,?,?,sysdate)", 
                        new String[] {"no"});
                  //SQL INSERT bno, title, content, id, regDate, viewCnt;
                  psmt.setInt(1,vo.getBno() ); //게시물 번호 불러오기 
                  psmt.setString(2,vo.getContent());   //content
                  psmt.setString(3,vo.getId());   //id

                  
                     System.out.println("dao끝났슈");
                     System.out.println(vo.getBno());
                     System.out.println(vo.getNo());
                     System.out.println(vo.getContent());
                     System.out.println(vo.getId());
                     System.out.println(vo.getRegDate());
                        
                  return psmt;
               }
            });
   }
   //글 수정하기
   @Override
   public void update(BoardVO boardvo) throws Exception {
      
      
      int a =jdbcTemplate.update(// update(PreparedStatementCreator객체,keyHolder);
            new PreparedStatementCreator() {
               
               @Override
               public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                  PreparedStatement psmt = con.prepareStatement(
                        "UPDATE board SET TITLE=?,CONTENT=? WHERE BNO=?", 
                        new String[] {"bno"});
                  //SQL INSERT bno, title, content, id, regDate, viewCnt;
                  psmt.setString(1,boardvo.getTitle() ); //title
                  psmt.setString(2,boardvo.getContent());   //content
                  psmt.setInt(3,boardvo.getBno());   //id
                  //                  System.out.println(board.getId());
                  //                  System.out.println(board.getTitle());
                  //                  System.out.println(board.getContent());
                  
                  
                  //                  System.out.println(board.getRegDate());
                  //                  System.out.println(member.getMemberId());
                  //                  System.out.println(board.getBno()+board.getTitle()+board.getRegDate()); //생성 번호, 제목, 작성일 출력
                  return psmt;
               }
            });
      System.out.println(boardvo.getTitle());
      System.out.println(boardvo.getContent());
      System.out.println(boardvo.getBno());
      
      
      System.out.println(a);
   }
   //
   //   //글 상세보기
   //   @Override
   //   public BoardVO read(int bno) throws Exception {
   //      // TODO Auto-generated method stub
   //      return null;
   //   }
   //   
   

   //bno를 통해 글 정보 불러오는 기능
   public BoardVO selectBybno(int bno) {
      System.out.println("selectBybno:"+bno);
      List<BoardVO> result = jdbcTemplate.query(
            "SELECT * FROM board WHERE bno=?", rowMapper, bno);
      return result.isEmpty()?null:result.get(0);
   }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //글 삭제
//   @Override
//   public void delete(BoardVO vo) throws Exception {
//      jdbcTemplate.update(
//            "DELETE FROM board WHERE bno=?",
//            vo.getBno()
//            );
//
//   }
   //글 삭제
   public void delete(BoardVO boardvo) throws Exception{
      jdbcTemplate.update(
            "DELETE FROM board WHERE bno=?",
            boardvo.getBno()
            );
      
   }
   
   // 댓글 삭제 
   public void replydelete(int no) throws Exception{
      System.out.println("replydelete"+no);
      jdbcTemplate.update(
            "DELETE FROM REPLY WHERE no=?",
            no
            );
      
   }
  

//   public void delete(Product product) {
//      jdbcTemplate.update(
//            "DELETE FROM product WHERE productNumber=?",
//            product.getProductNumber()
//            );
//   }
   //   this.bno = bno;
   //   this.title = title;
   //   this.content = content;
   //   this.regDate = regDate;
   //   this.viewCnt = viewCnt;
   //   this.id = id;
   //   
  


   //글 목록
   @Override
   public List<BoardVO> list() throws Exception {
      List<BoardVO> results = jdbcTemplate.query(
            "SELECT * FROM BOARD ORDER BY bno DESC" ,rowMapper);
      return results;
   }
   
   //댓글 리스트 불러오기

   @Override
   public List<ReplyVO> readReply(int bno) throws Exception {
      System.out.println("댓글리스트 불러오기"+bno);
      List<ReplyVO> results = jdbcTemplate.query(
            "SELECT * FROM reply WHERE bno=? ORDER BY no DESC",
            new RowMapper<ReplyVO>() {      
               
               @Override
               public ReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {   
                  ReplyVO replyvo = new ReplyVO(
                        
                        rs.getInt("bno"),
                        rs.getInt("no"),
                        rs.getString("content"),
                        rs.getString("id"),
                        rs.getDate("regDate")
                        
                        );
                     System.out.println(bno);
                  replyvo.setBno(rs.getInt("bno"));
                  return replyvo;
               }
               
            },bno);
               
      return results;
   }
   
//
   
//   @Override
//   public List<ReplyVO> readReply() throws Exception {
//      List<ReplyVO> results = jdbcTemplate.query(
//            "SELECT*FROM reply ORDER BY no DESC" ,
//            new RowMapper<ReplyVO>() {
//               @Override
//               public ReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//                  ReplyVO replyvo= new ReplyVO(
//                        rs.getInt("no"),
//                        rs.getString("Id"),
//                        rs.getString("content"),
//                        rs.getDate("regdate")
//                       
//                        
//                        );
//                  boardvo.setBno(rs.getInt("bno"));
//                  return boardvo;
//               }
//
//            });
//      return results;
//   }





   // 조회수 올리는 기능 
   @Override
   public void count(BoardVO vo) throws Exception {
      jdbcTemplate.update(
            "UPDATE board set viewCnt=? WHERE bno=?",
            (vo.getViewCnt()+1),
            vo.getBno()
            );
      
   }
   
   
   //댓글번호로 댓글 조회하기
   @Override
   public ReplyVO selectByreplyNo(int no) {
      System.out.println("selectByreplyNo"+no);
      List<ReplyVO> result = jdbcTemplate.query(
            "SELECT * FROM reply WHERE no=?", 
            new RowMapper<ReplyVO>() {

               @Override
               public ReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                  ReplyVO reply = new ReplyVO(
                        rs.getInt("no"),
                        rs.getInt("bno"),
                        rs.getString("content"),
                        rs.getString("Id"),
                        rs.getDate("regDate")
                        );
                  reply.setNo(rs.getInt("no"));
                  return reply;
               }

            },no);

      return result.isEmpty()?null:result.get(0);

   }
   
   // 글에 대한 전체 댓글 수 조회
   @Override
   public int countReply(int bno) {
      Integer cnt = jdbcTemplate.queryForObject(
            "SELECT count(*) FROM reply WHERE bno="+bno,
            Integer.class);
      return cnt;
   }
   @Override
    public int countBoard() {
      Integer cntboard = jdbcTemplate.queryForObject(
            "SELECT count(*) FROM board="+board,
            Integer.class);
      return cntboard;
}


@Override
public BoardVO read(int bno) throws Exception {
   // TODO Auto-generated method stub
   return null;
}


@Override
public void replywritd(ReplyVO vo) throws Exception {
   // TODO Auto-generated method stub
   
}

  
   
 








}