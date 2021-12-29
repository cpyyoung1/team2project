package spring.controller;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.dao.FaqDAO;
import spring.dao.FaqMenuDAO;
import spring.dao.MemberDao;
import spring.dao.NoticeDAO;
import spring.vo.FaqMenuVO;
import spring.vo.FaqVO;
import spring.vo.NoticeVO;

@Controller
@RequestMapping("/support")
public class SupportController {
	
	public MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

   
   private NoticeDAO noticeDAO;

   public void setNoticeDAO(NoticeDAO noticeDAO)
   {
      this.noticeDAO = noticeDAO;
   }
  
   
   private FaqDAO faqDAO;

   public void setFaqDAO(FaqDAO faqDAO)
   {
      this.faqDAO = faqDAO;
   }
   
   private FaqMenuDAO faqMenuDAO;

   public void setFaqMenuDAO(FaqMenuDAO faqMenuDAO)
   {
      this.faqMenuDAO = faqMenuDAO;
   }
   
   private JdbcTemplate jdbcTemplate;
   
//   @RequestMapping("/SupportMain/{faqMenuNumber}")
//      public String handlerStep(@PathVariable("faqMenuNumber") int faqMenuNumber, Model model) // 공지사항 갱신
//      {
//         List<NoticeVO> noticeList = noticeDAO.noticeList();
//         model.addAttribute("noticeList", noticeList);
//         
//         List<FaqVO> faqList = faqDAO.faqListByfaqMenuNumber(faqMenuNumber);
//         model.addAttribute("faqList", faqList);
//         model.addAttribute("current", faqMenuNumber);
//         return "support/SupportMain";
//      }

   @RequestMapping("/SupportMain")
   public String handlerStep(Model model) // 공지사항 갱신
   {
      List<NoticeVO> noticeList = noticeDAO.noticeList();
      model.addAttribute("noticeList", noticeList);
      
      List<FaqMenuVO> faqMenuList = faqMenuDAO.faqMenuList();
      model.addAttribute("faqMenuList", faqMenuList);
      
      List<FaqVO> faqList = faqDAO.faqList();
      model.addAttribute("faqList", faqList);
      return "support/SupportMain";
   }

   @RequestMapping("/Counsel")
   public String handlerStep1() {
      return "support/Counsel";
   }
   
   @RequestMapping("/findInfo")
   public String handlerStep2() {
      return "login/findInfo";
   }
   
   @RequestMapping("/findId")
   public String handlerStep3() {
      return "redirect:/login/findId";
   }
   
   @RequestMapping("/findPw")
   public String handlerStep4() {
      return "redirect:/login/findPw";
   }

   @RequestMapping("/Privacy")
   public String handlerStep5() {
      return "support/Privacy";
   }
   
   @RequestMapping("/registerNotice")
   public String registerForm()
   {
      return "support/NoticeRegister";
   }
   
   @RequestMapping("/location")
   public String handlerStep6()
   {
      return "support/location";
   }
   
   

   
   //문의하기 글 작성 
   @RequestMapping(value = "/toAdmin", method = RequestMethod.POST)
   public String toAdmin(FaqVO qna,Model model)throws Exception {	
	   faqDAO.insertQA(qna);  //문의글 등록   
	   
	   List<NoticeVO> noticeList = noticeDAO.noticeList();
	   model.addAttribute("noticeList", noticeList);
	      
	   List<FaqMenuVO> faqMenuList = faqMenuDAO.faqMenuList();
	   model.addAttribute("faqMenuList", faqMenuList);
	      
	   List<FaqVO> faqList = faqDAO.faqList();
	   model.addAttribute("faqList", faqList);
	   
	   return "support/SupportMain";
   }
   
   //문의 글 보기
   @RequestMapping("/QAList")
	public String ShowQA(Model model)throws Exception{
		List<FaqVO> qaList = faqDAO.qaList();
		model.addAttribute("qaList", qaList);
		return "support/QA";
	}
   
   //문의글 읽기
	@RequestMapping("/supportView/{qaNum}")
	public String Detail(@PathVariable("qaNum") int qno, Model model) {

		FaqVO qa = faqDAO.selectByQno(qno);
		model.addAttribute("readQA", qa);
		return "support/qaView";
	}
	//문의글 삭제
	@RequestMapping("/deleteQA/{qno}")
	public String delete(@PathVariable("qno") int qno,
			Model model) throws Exception{

		FaqVO qa = faqDAO.selectByQno(qno);

		faqDAO.selectDelete(qa);

		List<FaqVO> qlist = faqDAO.qaList();
		model.addAttribute("readQA", qlist);
		return "redirect:/support/QAList";
	}
	
}