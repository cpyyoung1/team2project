package spring.vo;

import java.util.Date;

public class FaqVO
{
	private int qaNum; //문의글 번호
	private String faqTitle;		//문의 제목
	private String faqContent;	//문의 내용
	private int faqMenuNumber;	//문의 유형
	private int faqNumber;	//문의 연락처
	private Date regDate; //작성일
	private String qid; //작성자

	//기본생성자
	public FaqVO() {

	}



	public String getQid() {
		return qid;
	}



	public void setQid(String qid) {
		this.qid = qid;
	}


	public FaqVO(int qaNum, String faqTitle, String faqContent, int faqMenuNumber, int faqNumber, Date regDate,
			String qid) {
		super();
		this.qaNum = qaNum;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqMenuNumber = faqMenuNumber;
		this.faqNumber = faqNumber;
		this.regDate = regDate;
		this.qid = qid;
	}



	public FaqVO(String faqTitle, String faqContent, int faqMenuNumber) {
		super();
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqMenuNumber = faqMenuNumber;
	}





	public void modify(String newTitle, String newContent, int newMenuNumber)
	{
		this.faqTitle = newTitle;
		this.faqContent = newContent;
		this.faqMenuNumber = newMenuNumber;
	}



	public int getQaNum() {
		return qaNum;
	}



	public void setQaNum(int qaNum) {
		this.qaNum = qaNum;
	}



	public int getFaqNumber() {
		return faqNumber;
	}



	public void setFaqNumber(int faqNumber) {
		this.faqNumber = faqNumber;
	}



	public String getFaqTitle() {
		return faqTitle;
	}



	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}



	public String getFaqContent() {
		return faqContent;
	}



	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}



	public int getFaqMenuNumber() {
		return faqMenuNumber;
	}



	public void setFaqMenuNumber(int faqMenuNumber) {
		this.faqMenuNumber = faqMenuNumber;
	}



	public Date getRegDate() {
		return regDate;
	}



	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


}