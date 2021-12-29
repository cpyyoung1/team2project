package spring.service;


import spring.dao.MemberDao;
import spring.dao.MessageDao;
import spring.exception.IdPasswordNotMatchingException;
import spring.vo.AuthInfo;
import spring.vo.Member;
import spring.vo.Message;

public class MessageService {

   
   private MessageDao messageDao;

   public MessageDao getMessageDao() {
      return messageDao;
   }

   public void setMessageDao(MessageDao messageDao) {
      this.messageDao = messageDao;
   }
   


//전송
   public void send(Message msg) throws Exception{
		   
      Message message = new Message(
            msg.getSender(),
            msg.getContent(),
            msg.getRegdate(),
            msg.getMno(),
            msg.getReciver()
            );
      messageDao.send(message);
   }

////수신자 확인
//   public Message ChkReciver(String ChkId)
//   {
//   Message chkMsg = messageDao.selectBymemberId(ChkId);
//   if(chkMsg==null) {
//      throw new IdPasswordNotMatchingException();
//   }
//   
//   return new AuthInfo(member.getMemberNumber(), member.getMemberName(), member.getMemberId()
//         ,member.getMemberPw(),member.getMemberTel(),member.getMemberAddress(),member.getMemberGrade(),
//         member.getMemberProfile(),member.getMemberPoint(),member.getMemberNickname() );
//   
//}
      
      
      
   
}
