package spring.service;

import spring.dao.FaqMenuDAO;
import spring.vo.FaqMenuVO;

public class FaqMenuRegisterService
{
   private FaqMenuDAO faqMenuDAO;

      public FaqMenuRegisterService(FaqMenuDAO faqMenuDAO)
      {
         this.faqMenuDAO = faqMenuDAO;
      }
      
      public void regist(FaqMenuVO faqMenuVO)
      {
         FaqMenuVO newFaqMenuVO = new FaqMenuVO
                     (
                           faqMenuVO.getFaqMenuTitle()
                        );
         
         System.out.println("FaqMenuRegisterService 실행");
         faqMenuDAO.insert(newFaqMenuVO);
      }
}