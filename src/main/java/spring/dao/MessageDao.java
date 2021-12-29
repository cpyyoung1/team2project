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
import spring.vo.Message;

public class MessageDao {


   private JdbcTemplate jdbcTemplate;


   private Message msg;
   private Member member;

   public Message getMessage() {
      return msg;
   }

   public void setMessage(Message msg) {
      this.msg = msg;
   }

   public Member getmember() {
      return member;
   }


   public void setMember(Member member) {
      this.member = member;
   }


   public void setDataSource(DataSource dataSource) {
      this.jdbcTemplate = new JdbcTemplate(dataSource);
   }


   //쪽지 보내기
   public void send(Message msg) throws Exception{
      KeyHolder keyHolder = new GeneratedKeyHolder();

      jdbcTemplate.update(
            new PreparedStatementCreator() {

               @Override
               public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                  PreparedStatement psmt = con.prepareStatement(
                        //sender, content, regdate, mno_seq, reciver
                        "INSERT INTO message VALUES(?,?,sysdate,msg_seq.nextval,?)", 
                        new String[] {"mno"});
                  psmt.setString(1,msg.getSender()); 
                  psmt.setString(2,msg.getContent());   
                  psmt.setString(3,msg.getReciver());  
                  return psmt;
               }
            },keyHolder);
   }
   

   
   //쪽지 읽기
   public Message selectView(int mno)
   {
      String sql = "SELECT * FROM message WHERE mno=?";
      List<Message> result = jdbcTemplate.query(sql, msgMapper, mno);
      return result.isEmpty()?null:result.get(0);
   }
   
   //쪽지 삭제
   public void selectDelete(Message mno)
   {
      jdbcTemplate.update(
            "DELETE FROM message WHERE mno=?",
            mno.getMno()
            );
   }
   
   

   //row Mapper
   RowMapper<Message> msgMapper =
         new RowMapper<Message>() {
      @Override
      public Message mapRow(ResultSet rs, int rowNum) throws SQLException
      {
         Message msg = new Message
               (
//               sender, content, date, number, reciver
               rs.getString("sender"),
               rs.getString("content"),
               rs.getDate("regdate"),
               rs.getInt("mno"),
               rs.getString("reciver")
               );
         msg.setMno(rs.getInt("mno"));
         return msg;
      }
   }; 
   
   RowMapper<Member> rowMapper =
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
   

   
   
   public int messagCnt(String id) {
	   String sql = "SELECT COUNT(*) from message WHERE reciver=?";
	   Integer reciveCnt = jdbcTemplate.queryForObject(sql, new Object[] {id},Integer.class);
	   return reciveCnt;
   }

   
   public List<Message> selectRecv()
   {
      String sql = "SELECT * FROM message WHERE reciver=? ORDER BY regdate ASC";
      List<Message> result = jdbcTemplate.query(sql,new RowMapper<Message>() {
         public Message mapRow(ResultSet rs, int rowNum) throws SQLException{
            Message msg = new Message(
            rs.getString("sender"),
            rs.getString("content"),
            rs.getDate("regdate"),
            rs.getInt("mno"),
            rs.getString("reciver"));
            msg.setMno(rs.getInt("mno"));
            return msg;
         }
      });
      return result;
   }

   
   //보낸 쪽지
   public List<Message> selectSend()
   {
      String sql = "SELECT * FROM message WHERE sender=? ORDER BY regdate ASC";  //메시지를 최근 날짜부터 조회
      List<Message> results = jdbcTemplate.query(sql,msgMapper);   
      return results;
   }


   public Message selectByMno(int mno)
   {
      String sql = "SELECT * FROM message WHERE mno=?";
      List<Message> result = jdbcTemplate.query(sql,new RowMapper<Message>() {
         public Message mapRow(ResultSet rs, int rowNum) throws SQLException{
            Message msg = new Message(
            rs.getString("sender"),
            rs.getString("content"),
            rs.getDate("regdate"),
            rs.getInt("mno"),
            rs.getString("reciver"));
            msg.setMno(rs.getInt("mno"));
            return msg;
         }
      },mno);
   
      
      return result.isEmpty()?null:result.get(0);

   }

   //멤버 조회
   public Member selectBymemberId(String memberId)
   {
      String sql = "SELECT * FROM member WHERE memberId=?";
      List<Member> result = jdbcTemplate.query(sql,rowMapper,memberId);
      return result.isEmpty()?null:result.get(0);

   }
   

   

   
   
   
   
   

      public List<Message> msgList() throws Exception {
         List<Message> results = jdbcTemplate.query(
               "SELECT * FROM message ORDER BY regdate DESC" ,
               new RowMapper<Message>() {
                  @Override
                  public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
                     Message msg= new Message(
                           (
                                rs.getString("sender")),
                                rs.getString("content"),
                                rs.getDate("regdate"),
                                rs.getInt("mno"),
                                rs.getString("reciver"));
                     msg.setMno(rs.getInt("mno"));;
                     return msg;
                  }

               });
         return results;
      }
}