package spring.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.BoardDAO;
import spring.service.BoardServiceImpl;
import spring.vo.AuthInfo;
import spring.vo.BoardVO;
import spring.vo.ReplyVO;

@Controller
@RequestMapping("/community")
public class BoardController {

   private BoardServiceImpl boardservice;
   private BoardDAO BoardDAO;
   private AuthInfo authinfo;
   public void setBoardservice(BoardServiceImpl boardservice) {
      this.boardservice = boardservice;
   }

   public void setBoardDAO(BoardDAO BoardDAO) {
      this.BoardDAO = BoardDAO;
   }

   @RequestMapping("/CommunityInsert")   
   public String handlerStep1() {
      return "community/CommunityInsert";
   }
   
   @RequestMapping("/BoardNotice")   
   public String handlerStep2() {
      return "community/BoardNotice";
   }

   //게시글 자세히보기
   @RequestMapping("/CommunityView/{bno}")
   public String Detail(@PathVariable("bno") int bno, Model model) throws Exception {


      BoardVO BoardVO = BoardDAO.selectBybno(bno);
      List<ReplyVO> list = BoardDAO.readReply(bno);
      model.addAttribute("list",list);
      BoardDAO.count(BoardVO);
      if(BoardVO==null) {
         System.out.println("글 정보를 불러올 수 없습니다.");
      }
      int num = BoardDAO.countReply(bno);

      model.addAttribute("replyNum", num);
      model.addAttribute("BoardVO", BoardVO);
      return "community/CommunityView";
   }


   //글 삭제
   @RequestMapping("CommunityList/delete/{bno}")
   public String delete(@PathVariable("bno") int bno, Model model) throws Exception {

      BoardVO boardvo = BoardDAO.selectBybno(bno);

      List<BoardVO> BoardVO = BoardDAO.list();
      model.addAttribute("BoardVO", boardvo);
      BoardDAO.delete(boardvo);
      List<BoardVO> list = BoardDAO.list();
      model.addAttribute("list", list);

      return "community/CommunityList";
   }
     //댓글 삭제 
    @RequestMapping("CommunityView/replydelete/{no}/{bno}")
     public String Replydelete(@PathVariable("no") int no,@PathVariable("bno") int bno, Model model) throws Exception{
           System.out.println("삭제 컨트롤러");
        
       ReplyVO replyvo = BoardDAO.selectByreplyNo(no);
        
        BoardDAO.replydelete(no);
        
        
         BoardVO BoardVO = BoardDAO.selectBybno(bno);
       
         List<ReplyVO> list = BoardDAO.readReply(bno);       
         int num = BoardDAO.countReply(bno);

         model.addAttribute("replyNum", num);
         model.addAttribute("list",list);
         BoardDAO.count(BoardVO);
         model.addAttribute("BoardVO", BoardVO);
         return "community/CommunityView";
     }

   // 글 작성 post
   @RequestMapping(value = "/write", method = RequestMethod.POST)
   public String postWrite(BoardVO vo,Model model) throws Exception {
      //         logger.info("post write");

      boardservice.write(vo);
      System.out.println("확인이요");
      
      List<BoardVO> list = BoardDAO.list();
      model.addAttribute("list", list);

      return "/community/CommunityList";
   }

   //댓글 작성 
   @RequestMapping(value ="replywrite", method=RequestMethod.POST)
   public String replyWrite(ReplyVO vo,Model model) throws Exception{
      System.out.println("댓글작성 컨트롤러");
      
      BoardDAO.writeReply(vo);
      BoardVO BoardVO = BoardDAO.selectBybno(vo.getBno());
        System.out.println(vo.getNo());
      model.addAttribute("BoardVO", BoardVO);
      int num = BoardDAO.countReply(BoardVO.getBno());
      model.addAttribute("replyNum", num);
      List<ReplyVO> list = BoardDAO.readReply(vo.getBno());
      model.addAttribute("list", list);

      return "/community/CommunityView";
   }



   //글 수정 페이지에 글정보 불러오기
   @RequestMapping(value = "CommunityModify/update/{bno}")
   public String getModify(@PathVariable("bno") int bno,Model model) throws Exception {
      //       logger.info("get update");

      //       BoardDAO.update(bno);
      BoardVO boardvo = BoardDAO.selectBybno(bno);

      model.addAttribute("BoardVO", boardvo);
      return "/community/CommunityModify";

   }

   // 글 수정하기
   @RequestMapping(value="modification", method=RequestMethod.POST)
   public String getupdate(BoardVO vo,Model model) throws Exception {
      System.out.print("*글 수정 컨트롤러*");
      System.out.println(vo.getTitle());
      System.out.println(vo.getContent());
      System.out.println(vo.getBno());

      boardservice.update(vo);
      List<BoardVO> list = BoardDAO.list();
      model.addAttribute("list", list);
      return "/community/CommunityList";
   }


   //////////////////////////////////
   // 글 목록
   @RequestMapping(value = "/CommunityList", method = RequestMethod.GET)
   public String list(Model model) throws Exception {
      
      List<BoardVO> list = BoardDAO.list();
      model.addAttribute("list", list);
      
      return "/community/CommunityList";

   }


}