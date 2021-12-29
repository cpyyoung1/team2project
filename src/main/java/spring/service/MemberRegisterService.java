package spring.service;

import java.util.Date;

import spring.dao.MemberDao;
import spring.exception.AlreadyExistingMemberException;
import spring.vo.Member;
import spring.vo.RegisterRequest;

public class MemberRegisterService {
   
   private MemberDao memberDao; // = new MemberDao();

   public MemberRegisterService(MemberDao memberDao) {
      this.memberDao = memberDao;
   }

   public void regist(RegisterRequest req) {
      Member member = memberDao.selectBymemberId(req.getMemberId() );
      if (member != null) {
         throw new AlreadyExistingMemberException("dup MemberId " + req.getMemberId() );
      }
      Member newMember = new Member(
            req.getMemberNumber(), req.getMemberName(), req.getMemberId(),req.getMemberPw(),req.getMemberTel()
            ,req.getMemberAddress(),
            req.getMemberGrade(), req.getMemberProfile(),req.getMemberPoint(), req.getMemberNickname()
            );
      
      memberDao.insert(newMember);
   }
   
   public int nickChk(RegisterRequest req) // 닉네임 중복체크
   {
      Member result = memberDao.selectBymemberNickname(req.getMemberNickname() );
      
      if (result != null) // 닉네임이 존재함
      {
         return 1;
      }
      else
      {
         return 0;
      }
   }
   
   public int telChk(RegisterRequest req) // 닉네임 중복체크
   {
      Member result = memberDao.selectBymemberTel(req.getMemberTel() );
      
      if (result != null) // 연락처가 존재함
      {
         return 1;
      }
      else
      {
         return 0;
      }
   }
   
   
}
//psmt.setString(1,member.getMemberName());
//psmt.setString(2,member.getMemberId());
//psmt.setString(3,member.getMemberPw());
//psmt.setString(4,member.getMemberTel());
//psmt.setString(5,member.getMemberAddress());
//psmt.setInt(6,member.getMemberGrade());
//psmt.setString(7,member.getMemberProfile());
//psmt.setInt(8,member.getMemberPoint());