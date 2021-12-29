package spring.service;

import spring.dao.MemberDao;
import spring.exception.IdPasswordNotMatchingException;
import spring.exception.MemberNotFoundException;
import spring.vo.AuthInfo;
import spring.vo.Member;

public class AuthService {// 회원 인증 기능=> 빈 객체로 등록 => 주입을 받는다.
   
   private MemberDao memberDao;

   public void setMemberDao(MemberDao memberDao) {
      this.memberDao = memberDao;
   }
   
   public AuthInfo authenticate(String memberId, String memberPw) {
      Member member = memberDao.selectBymemberId(memberId);
      
      if(member==null) {
         throw new IdPasswordNotMatchingException();
      }
//      if(!member.getPassword().equals(password)) {
      if(!member.matchPassword(memberPw)) {
         throw new IdPasswordNotMatchingException();
      }
      
      return new AuthInfo(member.getMemberNumber(), member.getMemberName(), member.getMemberId()
            ,member.getMemberPw(),member.getMemberTel(),member.getMemberAddress(),member.getMemberGrade(),
            member.getMemberProfile(),member.getMemberPoint(),member.getMemberNickname() );
      
   }
   
   public AuthInfo sessionReset(String memberId)
   {
      Member member = memberDao.selectBymemberId(memberId);
      
      return new AuthInfo(member.getMemberNumber(), member.getMemberName(), member.getMemberId()
               ,member.getMemberPw(),member.getMemberTel(),member.getMemberAddress(),member.getMemberGrade(),
               member.getMemberProfile(),member.getMemberPoint(),member.getMemberNickname() );
   }
   
   public AuthInfo findId(String memberName, String memberTel)
   {
      Member member = memberDao.selectBymemberTel(memberTel);
      
      if(member == null)
      {
          throw new MemberNotFoundException();
      }
      
      if(!member.getMemberName().equals(memberName) )
      {
         throw new MemberNotFoundException();
      }
      
      return new AuthInfo(member.getMemberNumber(), member.getMemberName(), member.getMemberId()
               ,member.getMemberPw(),member.getMemberTel(),member.getMemberAddress(),member.getMemberGrade(),
               member.getMemberProfile(),member.getMemberPoint(),member.getMemberNickname() );
   }
   
   public AuthInfo findPw(String memberId, String memberName, String memberTel)
   {
      Member member = memberDao.selectBymemberId(memberId);
      
      if(member == null)
      {
          throw new MemberNotFoundException();
      }
      
      if(!member.getMemberName().equals(memberName) )
      {
         throw new MemberNotFoundException();
      }
      
      if(!member.getMemberTel().equals(memberTel) )
      {
         throw new MemberNotFoundException();
      }
      
      return new AuthInfo(member.getMemberNumber(), member.getMemberName(), member.getMemberId()
               ,member.getMemberPw(),member.getMemberTel(),member.getMemberAddress(),member.getMemberGrade(),
               member.getMemberProfile(),member.getMemberPoint(),member.getMemberNickname() );
   }
   
   public void modifyPassword(String memberId, String currPw, String newPw, String confPw) // 비밀변호 변경
   {
      Member member = memberDao.selectBymemberId(memberId);
      
      if (!currPw.equals(member.getMemberPw() ) )
      {
         throw new MemberNotFoundException();
      }
      
      member.changePassword(currPw, newPw);
      memberDao.update(member);
   }
   
   public void modifyNickname(String memberId, String memberNickname) // 닉네임 변경
   {
      Member otherMember = memberDao.selectBymemberNickname(memberNickname);
      Member member = memberDao.selectBymemberId(memberId);
      if(otherMember == null)
       {
         member.setMemberNickname(memberNickname);
         memberDao.update(member);
       }
      else
      {
         throw new MemberNotFoundException();
      }
   }
   
   public void modifyAddress(String memberId, String memberAddress) // 주소 변경
   {
      Member member = memberDao.selectBymemberId(memberId);
      member.setMemberAddress(memberAddress);
      memberDao.update(member);
   }
   
   

}