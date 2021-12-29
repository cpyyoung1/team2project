package spring.service;

import java.util.Date;

import spring.dao.FaqDAO;
import spring.dao.NoticeDAO;
import spring.vo.FaqVO;
import spring.vo.NoticeRegister;
import spring.vo.NoticeVO;

public class FaqRegisterService
{
      private FaqDAO faqDAO;

      public FaqRegisterService(FaqDAO faqDAO)
      {
         this.faqDAO = faqDAO;
      }
      
      public void regist(FaqVO faqvo)
      {
         FaqVO newFaqVO = new FaqVO
                     (
                           faqvo.getFaqTitle(), faqvo.getFaqContent(), faqvo.getFaqMenuNumber()
                        );
         
         System.out.println("FaqRegisterService 실행");
         faqDAO.insert(newFaqVO);
      }
}