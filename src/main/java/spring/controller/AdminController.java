package spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.BoardDAO;
import spring.dao.FaqDAO;
import spring.dao.FaqMenuDAO;
import spring.dao.MemberDao;
import spring.dao.NoticeDAO;
import spring.dao.ProductDAO;
import spring.service.FaqMenuRegisterService;
import spring.service.FaqRegisterService;
import spring.service.NoticeRegisterService;
import spring.vo.BoardVO;
import spring.vo.FaqMenuVO;
import spring.vo.FaqVO;
import spring.vo.Member;
import spring.vo.NoticeRegister;
import spring.vo.NoticeVO;
import spring.vo.Order;
import spring.vo.Product;

@Controller
@RequestMapping("/admin")
public class AdminController {

   private MemberDao memberDao;

   public void setMemberDao(MemberDao memberDao) {
      this.memberDao = memberDao;
   }

   private ProductDAO productDAO;

   public void setProductDAO(ProductDAO productDAO) {
      this.productDAO = productDAO;
   }

   private NoticeDAO noticeDAO;

   public void setNoticeDAO(NoticeDAO noticeDAO) {
      this.noticeDAO = noticeDAO;
   }

   private NoticeRegisterService noticeRegisterService;

   public void setNoticeRegisterService(NoticeRegisterService noticeRegisterService)
   {
      this.noticeRegisterService = noticeRegisterService;
   }

   private FaqDAO faqDAO;

   public void setFaqDAO(FaqDAO faqDAO) {
      this.faqDAO = faqDAO;
   }

   private FaqRegisterService faqRegisterService;

   public void setFaqRegisterService(FaqRegisterService faqRegisterService)
   {
      this.faqRegisterService = faqRegisterService;
   }

   private FaqMenuDAO faqMenuDAO;

   public void setFaqMenuDAO(FaqMenuDAO faqMenuDAO) {
      this.faqMenuDAO = faqMenuDAO;
   }

   private FaqMenuRegisterService faqMenuRegisterService;

   public void setFaqMenuRegisterService(FaqMenuRegisterService faqMenuRegisterService)
   {
      this.faqMenuRegisterService = faqMenuRegisterService;
   }
   
   private BoardDAO BoardDAO;

   public void setBoardDAO(BoardDAO BoardDAO) {
      this.BoardDAO = BoardDAO;
   }
   
   @RequestMapping("/adminpageMain")   //?????? ???????????? ???????????? ??????
   public String handlerStep1() {
      return "admin/adminpageMain";
   }

   @RequestMapping("/inputNotice")   //?????? ???????????? ???????????? ??????
   public String handlerStep2() {
      return "admin/inputNotice";
   }

    @RequestMapping(value="/registerNotice", method=RequestMethod.POST) // ???????????? ??????
     public String registerNoti(NoticeRegister notReg)
     {
        try
        {
           noticeRegisterService.regist(notReg);
           return "redirect:/support/SupportMain";
        }
        catch(Exception e)
        {
           return "admin/inputNoitce";
        }
     }

     @RequestMapping(value="/modifyNoticeForm/{noticeNumber}", method=RequestMethod.GET) // ???????????? ?????? ???
     public String modifyNotiForm(@PathVariable("noticeNumber") int noticeNumber, Model model)
     {   
        NoticeVO noticeVO = noticeDAO.selectBynoticeNumber(noticeNumber);
        model.addAttribute("nVO", noticeVO);
        return "admin/modifyNotice";
     }

     @RequestMapping(value="/modifyNoticeForm/modifyNotice", method=RequestMethod.POST) // ???????????? ??????
     public String modifyNoti(NoticeRegister notReg)
     {
        try
        {
           NoticeVO noticeVO = noticeDAO.selectBynoticeNumber(notReg.getNumber() );
           noticeVO.modify(notReg.getTitle(), notReg.getContent());
           noticeDAO.update(noticeVO);
           return "redirect:/support/SupportMain";
        }
        catch(Exception e)
        {
           return "redirect:/support/SupportMain";
        }
     }

     @RequestMapping(value="/deleteNotice/{noticeNumber}", method=RequestMethod.GET) // ???????????? ??????
     public String deleteNoti(@PathVariable("noticeNumber") int noticeNumber)
     {
        try
        {
           NoticeVO noticeVO = noticeDAO.selectBynoticeNumber(noticeNumber);
           noticeDAO.delete(noticeVO);
           return "redirect:/support/SupportMain";
        }
        catch(Exception e)
        {
           return "redirect:/support/SupportMain";
        }
     }
     
     @RequestMapping("/inputFaq")
     public String inputFaq(Model model)
     {
       try
       {
           List<FaqMenuVO> faqMenuList = faqMenuDAO.faqMenuList();
           model.addAttribute("faqMenuList", faqMenuList);
           return "admin/inputFaq"; 
       }
       catch(Exception e)
       {
          return "admin/adminpageMain";
       }
     }

     @RequestMapping(value="/registerFaq", method=RequestMethod.POST) // FAQ ??????
     public String registerFaq(FaqVO faqVO)
     {
        try
        {
           faqRegisterService.regist(faqVO);
           return "redirect:/support/SupportMain";
        }
        catch(Exception e)
        {
           return "admin/inputFaq";
        }
     }
     
     @RequestMapping(value="/modifyFaqForm/{faqNumber}", method=RequestMethod.GET) // FAQ ?????? ???
     public String modifyFaqForm(@PathVariable("faqNumber") int faqNumber, Model model)
     {   
        FaqVO faqVO = faqDAO.selectByfaqNumber(faqNumber);
        model.addAttribute("fVO", faqVO);
        List<FaqMenuVO> faqMenuList = faqMenuDAO.faqMenuList();
        model.addAttribute("faqMenuList", faqMenuList);
        return "admin/modifyFaq";
     }
     
     @RequestMapping(value="/modifyFaqForm/modifyFaq", method=RequestMethod.POST) // FAQ ??????
     public String modifyFaq(FaqVO faqVO)
     {
        try
        {
           FaqVO newFaqVO = faqDAO.selectByfaqNumber(faqVO.getFaqNumber() );
           
           newFaqVO.modify(faqVO.getFaqTitle(), faqVO.getFaqContent(), faqVO.getFaqMenuNumber() );
           faqDAO.update(newFaqVO);
           return "redirect:/support/SupportMain";
        }
        catch(Exception e)
        {
           return "redirect:/support/SupportMain";
        }
     }
     
     @RequestMapping(value="/deleteFaq/{faqNumber}", method=RequestMethod.GET) // FAQ ??????
     public String deleteFaq(@PathVariable("faqNumber") int faqNumber)
     {
        try
        {
           FaqVO faqVO = faqDAO.selectByfaqNumber(faqNumber);
           faqDAO.delete(faqVO);
           return "redirect:/support/SupportMain";
        }
        catch(Exception e)
        {
           return "redirect:/support/SupportMain";
        }
     }
     
     @RequestMapping("/inputFaqMenu")
     public String inputFaqMenu()
     {
        return "admin/inputFaqMenu";
     }

     @RequestMapping(value="/registerFaqMenu", method=RequestMethod.POST) // FAQ?????? ??????
     public String registerFaqMenu(FaqMenuVO faqMenuVO)
     {
        try
           {
              faqMenuRegisterService.regist(faqMenuVO);
              return "redirect:/support/SupportMain";
           }
           catch(Exception e)
           {
              return "admin/inputFaqMenu";
           }
     }
     
     @RequestMapping(value="/deleteFaqMenuForm") // FAQ?????? ?????? ???
     public String deleteFaqMenuForm(Model model)
     {
        try
        {
           List<FaqMenuVO> faqMenuList = faqMenuDAO.faqMenuList();
           model.addAttribute("faqMenuList", faqMenuList);
           return "admin/deleteFaqMenu";
        }
        catch(Exception e)
        {
           return "admin/deleteFaqMenu";
        }
     }
     
     @RequestMapping(value="/deleteFaqMenu", method=RequestMethod.POST)
     public String deleteFaqMenu(FaqMenuVO faqMenuVO)
     {
        try
        {
           FaqMenuVO newFaqMenuVO = faqMenuDAO.selectByfaqNumber(faqMenuVO.getFaqMenuNumber() );
           faqMenuDAO.delete(newFaqMenuVO);
           FaqVO faqVO = faqDAO.selectByfaqMenuNumber(faqMenuVO.getFaqMenuNumber() );
           if(faqVO!=null)
           {
              faqDAO.delete(faqVO);
           }
           return "redirect:/support/SupportMain";
        }
        catch(Exception e)
        {
           return "admin/deleteFaqMenu";
        }
     }




   // ?????? ????????? ??????
   @RequestMapping("/memberDetails/{memberNumber}")
   public String Detail(@PathVariable("memberNumber") int memberNumber, Model model) {
      try {
         Member member = memberDao.selectBymemberNumber(memberNumber);

      if(member==null) {
         System.out.println("??????????????? ????????? ??? ????????????.");
      }

      model.addAttribute("member", member);

      return "admin/memberDetails";
      
      }catch(Exception e) {
         return "admin/viewAllMembers";
      }

      
   }

   //?????? ?????? ????????????
   @RequestMapping("/viewAllMembers")
   public String list(Model model) {
      try {
         List<Member> members = memberDao.selectAll();
      model.addAttribute("members", members);

      int num = memberDao.count();
      model.addAttribute("num", num);

      return "admin/viewAllMembers";
      
      }catch(Exception e) {
         return "admin/adminpageMain";
      }
      
   }

   //?????? ???????????? ??????
   @RequestMapping("/delete/{memberNumber}")
   public String delete(@PathVariable("memberNumber") int memberNumber,
         Model model) {

      try {
         Member member = memberDao.selectBymemberNumber(memberNumber);

         //?????? ????????? ????????? ????????? ????????? ??????????????? ??????
         List<Product> products = productDAO.selectAll();
         for(int i=0;i<products.size();i++) {
            if(products.get(i).getMemberNumber()==memberNumber) {
               productDAO.delete(products.get(i));
            }
         }
         
         //?????? ????????? ????????? ????????? ????????? ??????????????? ??????
         List<BoardVO> boards = BoardDAO.list();
         for(int i=0;i<boards.size();i++) {
            if(boards.get(i).getId().equals(member.getMemberId())) {
               BoardDAO.delete(boards.get(i));
            }
         }

         if(member!=null) {
            memberDao.delete(member);         
         }else {
            System.out.println("????????? ?????? ??? ????????????.");
         }

         List<Member> members = memberDao.selectAll();
         model.addAttribute("members", members);

         return "admin/viewAllMembers";
         
      }catch(Exception e) {
         List<Member> members = memberDao.selectAll();
         model.addAttribute("members", members);
         
         return "admin/viewAllMembers";
      }
      
   }


   //?????? ?????? ??????
   @RequestMapping("/deleteProduct/{productNumber}/{categoryNumber}")
   public String deleteProduct(@PathVariable("productNumber") int productNumber,
         @PathVariable("categoryNumber") int categoryNumber, Model model) {

      try {
         Product product = productDAO.selectByproductNumber(productNumber);

         if(product!=null) {
            productDAO.likeProductDelete(product);
            productDAO.delete(product);   
         }else {
            System.out.println("????????? ?????? ??? ????????????.");
         }

         List<Product> products = productDAO.selectAll();
         model.addAttribute("products", products);
         
      }catch(Exception e) {
         
      }
      if(categoryNumber==1) {
         return "product/sofa";
      }else if(categoryNumber==2) {
         return "product/bed";
      }else if(categoryNumber==3) {
         return "product/table";
      }else if(categoryNumber==4) {
         return "product/lighting";
      }else if(categoryNumber==5) {
         return "product/drawer";
      }else {
         return "product/acc";
      }
   }

   //??????????????????
   @RequestMapping("/viewAllOrders")
   public String orderList(Model model) {
      List<Order> orders = productDAO.orderSelectAll();
      model.addAttribute("order", orders);

      //??????????????? ????????????
      int totalPrice = 0;
      for(int i=0;i<orders.size();i++) {
         totalPrice += orders.get(i).getProductPrice();
      }
      model.addAttribute("totalPrice", totalPrice);

      return "admin/viewAllOrders";
   }
   
   //???????????? ?????? ??????
   @RequestMapping("/searchMember")
   public String searchMember(@RequestParam(value = "memberId",required = false) String memberId,Model model) {
      
      List<Member> members = memberDao.FindMemberForID(memberId);
      model.addAttribute("members", members);
      
      int num = members.size();
      model.addAttribute("num", num);
      
      return "admin/viewAllMembers";
   }
   

}