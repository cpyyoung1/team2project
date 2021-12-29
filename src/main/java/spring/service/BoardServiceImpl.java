package spring.service;

import java.util.Date;
import java.util.List;

import spring.dao.BoardDAO;
import spring.vo.AuthInfo;
import spring.vo.BoardVO;
import spring.vo.Member;
import spring.vo.ReplyVO;
import spring.vo.SearchCriteria;




public class BoardServiceImpl implements BoardService{
   

   private BoardDAO dao;
   private Member member;
   public void setDao(BoardDAO dao) {
      this.dao = dao;
   }

   public void BoardDAO(BoardDAO dao) {
      this.dao = dao;
   }

//   private int bno;      //게시물번호
//   private String title;   //제목
//   private String content;   //내용
//   private String id;   //회원아이디
//   private Date regDate;   //작성일
//   private int viewCnt;   //조회수
//   
   //작성
   @Override
   public void write(BoardVO vo) throws Exception{
         
      BoardVO newBoardVO = new BoardVO(
            vo.getBno(),
            vo.getTitle(),
            vo.getContent(),
            vo.getRegDate(),
            vo.getViewCnt(),
            vo.getId()
            );
      
      dao.write(newBoardVO);
   }

   //조회
   @Override
   public BoardVO read(int bno) throws Exception {
      return dao.read(bno);
      
   }
   
   //수정
   @Override
   public void update(BoardVO vo) throws Exception {
      dao.update(vo);
      
   }

   //삭제
   @Override
   public void delete(BoardVO vo) throws Exception {
      dao.delete(vo);
      
   }
   
   //글목록
   @Override
   public List<BoardVO> list() throws Exception {
      
      BoardVO newBoardVO = new BoardVO();
      
      return dao.list();
   }

//   //목록 + 페이징
//   @Override
//   public List<BoardVO> listPage(Criteria cri) throws Exception {
//      return dao.listPage(cri);
//   }
//
//   //게시물 총 개수
//   @Override
//   public int listCount() throws Exception {
//      return dao.listCount();
//   }
//
//   // 목록 + 페이징 + 검색
//   @Override
//   public List<BoardVO> listSearch(SearchCriteria scri) throws Exception {
//      return dao.listSearch(scri);
//   }
//
//   // 검색 결과 갯수
//   @Override
//   public int countSearch(SearchCriteria scri) throws Exception {
//      return dao.countSearch(scri);
//   }
//
//   @Override
//   public List<ReplyVO> readReply(int bno) throws Exception {
//      return dao.readReply(bno);
//   }
   
}