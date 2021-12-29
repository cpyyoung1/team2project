package spring.survey;

import java.util.List;

public class AnsweredData {

	private Respondent red;// 여러가지 프로퍼티를 가진 또 다른 객체
	private List<String> response; // 여러가지 데이터를 가지는 리스트
	
	public Respondent getRed() {
		return red;
	}
	public void setRed(Respondent red) {
		this.red = red;
	}
	public List<String> getResponse() {
		return response;
	}
	public void setResponse(List<String> response) {
		this.response = response;
	}
	

}
