package spring.dao;

import java.util.List; 

import spring.vo.BoardVO;
import spring.vo.Criteria;
import spring.vo.ReplyVO;
import spring.vo.SearchCriteria;



public interface BoardDAO {

   // 작성
   public void write(BoardVO vo) throws Exception;

   // 조회
   public BoardVO read(int bno) throws Exception;

   // 수정
   public void update(BoardVO boardvo) throws Exception;

   // 삭제
   public void delete(BoardVO vo) throws Exception;

   // 상세보기
   public BoardVO selectBybno (int bno) throws Exception;
   // 목록
   public List<BoardVO> list() throws Exception;
   
   // 조회수 올리기
   public void count(BoardVO vo) throws Exception;
   
   //댓글 작성
   public void replywritd(ReplyVO vo) throws Exception;
   
// 댓글 조회
   public List<ReplyVO> readReply(int bno) throws Exception;

   //댓글 작성
   public void writeReply(ReplyVO vo) throws Exception;
   //댓글 삭제
   public void replydelete(int no) throws Exception;
   
   //no로 bno를 찾는 메서드
   public ReplyVO selectByreplyNo(int no) throws Exception;

   //글번호로 댓글수 조회
   public int countReply(int bno);

   public int countBoard();


   //   // 목록 + 페이징
   //   public List<BoardVO> listPage(Criteria cri) throws Exception;
   //   
   //   // 게시물 총 갯수
   //   public int listCount() throws Exception;
   //   
   //   // 목록 + 페이징 + 검색
   //   public List<BoardVO> listSearch(SearchCriteria scri) throws Exception;
   //      
   //   // 검색 결과 갯수
   //   public int countSearch(SearchCriteria scri) throws Exception;

   // 댓글 조회
 



   


}