package spring.vo;

public class SearchCriteria extends Criteria{ 
   private String searchType ="";
   private String keyword = "";
   private int page;
   private int perPageNum;
   
   
   public int getPage() {
      return page;
   }
   public void setPage(int page) {
      this.page = page;
   }
   public int getPerPageNum() {
      return perPageNum;
   }
   public void setPerPageNum(int perPageNum) {
      this.perPageNum = perPageNum;
   }
   public String getSearchType() {
      return searchType;
   }
   public void setSearchType(String searchType) {
      this.searchType = searchType;
   }
   public String getKeyword() {
      return keyword;
   }
   public void setKeyword(String keyword) {
      this.keyword = keyword;
   }
   
   @Override
   public String toString() {
      return super.toString() + " SearchCriteria [searchType=" + searchType + ", keyword="
            + keyword + "]";
   }

}