package spring.service;

import java.util.Date;

import spring.dao.NoticeDAO;
import spring.vo.NoticeRegister;
import spring.vo.NoticeVO;

public class NoticeRegisterService
{
   private NoticeDAO noticeDAO;

   public NoticeRegisterService(NoticeDAO noticeDAO)
   {
      this.noticeDAO = noticeDAO;
   }
   
   public void regist(NoticeRegister noticeReg)
   {
      NoticeVO noticeVO = new NoticeVO
                  (
                     noticeReg.getTitle(), noticeReg.getContent(), new Date()
                     );
      
      System.out.println("NoticeRegisterService 실행");
      noticeDAO.insert(noticeVO);
   }
}