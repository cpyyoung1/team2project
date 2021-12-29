package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import spring.exception.MemberNotFoundException;
import spring.vo.Member;

public class MemberDao {//데이터베이스 연결과 쿼리전송

	private JdbcTemplate jdbcTemplate;
	private Member member;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

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

	public void update(Member member) {
		jdbcTemplate.update(
				"UPDATE member set memberNickname=?, memberPw=?, memberAddress=? WHERE MemberNumber=?",
				member.getMemberNickname(),
				member.getMemberPw(),
				member.getMemberAddress(),
				member.getMemberNumber()
				);
	}

	public void delete(Member member) {
		jdbcTemplate.update(
				"DELETE FROM member WHERE MemberNumber=?",
				member.getMemberNumber()
				);
	}

	// 회원가입 기능
	public void insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(// update(PreparedStatementCreator객체,keyHolder);
				new PreparedStatementCreator() {

					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement psmt = con.prepareStatement(
								"INSERT INTO member VALUES(SEQ_MEMBERNUMBER.NEXTVAL,?,?,?,?,?,1,?,0,?)",
								new String[] {"memberId"});
						psmt.setString(1,member.getMemberName() );
						psmt.setString(2,member.getMemberId() );
						psmt.setString(3,member.getMemberPw() );
						psmt.setString(4,member.getMemberTel() );
						psmt.setString(5,member.getMemberAddress() );
						psmt.setString(6,member.getMemberProfile() );
						psmt.setString(7,member.getMemberNickname() );

						System.out.println(member.getMemberNumber() );
						return psmt;
					}
				},keyHolder);
		// Number keyValue = keyHolder.getKey();
		// member.setMemberNumber(keyValue.intValue() );

	}


	// 전체 회원보기
	public List<Member> selectAll()
	{
		String sql = "SELECT * FROM member ORDER BY memberNumber ASC";
		List<Member> results = jdbcTemplate.query(sql,rowMapper);
		return results;
	}
	
	// 전체 회원 수 조회
	public int count() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(*) FROM Member",
				Integer.class);
		return cnt;
	}
	
	// 멤버 아이디로 멤버 조회하기
	public Member selectBymemberId(String memberId)
	{
		String sql = "SELECT * FROM member WHERE memberId=?";
		List<Member> result = jdbcTemplate.query(sql,rowMapper,memberId);
		return result.isEmpty()?null:result.get(0);

	}
	
	// 회원번호로 멤버 조회하기
	public Member selectBymemberNumber(int memberNumber)
	{
		String sql = "SELECT * FROM member WHERE memberNumber=?";
		List<Member> result = jdbcTemplate.query(sql,rowMapper,memberNumber);
		return result.isEmpty()?null:result.get(0);

	}

	public Member selectBymemberNickname(String memberNickname)
	{
		String sql = "SELECT * FROM member WHERE memberNickname=?";
		List<Member> result = jdbcTemplate.query(sql,rowMapper,memberNickname);
		return result.isEmpty()?null:result.get(0);
	}

	public Member selectBymemberTel(String memberTel)
	{
		String sql = "SELECT * FROM member WHERE memberTel=?";
		List<Member> result = jdbcTemplate.query(sql,rowMapper,memberTel);
		return result.isEmpty()?null:result.get(0);

	}

	//포인트 충전하기
	public void changePoint(int payMoney,Member member1) {
		jdbcTemplate.update(
				"UPDATE member set memberPoint=? WHERE memberNumber=?",
				(member1.getMemberPoint()+payMoney),
				member1.getMemberNumber()
				);

	}

	//상품 판매완료시 포인트 충전
	public void plus(int price, Member seller) {
		jdbcTemplate.update(
				"UPDATE member set memberPoint=? WHERE memberNumber=?",
				(seller.getMemberPoint()+price),
				seller.getMemberNumber()
				);
		System.out.println("돈충전 완료!");
		
	}
	
	//구매시 포인트 차감
	public void minus(int price, Member buyer) {
		jdbcTemplate.update(
				"UPDATE member set memberPoint=? WHERE memberNumber=?",
				(buyer.getMemberPoint()-price),
				buyer.getMemberNumber()
				);
		
	}
	
	//아이디로 멤버찾기
	public List<Member> FindMemberForID(String memberId)
	{
		memberId = "%"+memberId+"%";
		
		String sql = "SELECT * FROM member WHERE memberId like ?";
		List<Member> results = jdbcTemplate.query(sql,rowMapper,memberId);
		return results;
	}
	
}