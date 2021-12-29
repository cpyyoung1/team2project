package spring.survey;

import java.util.Collections;
import java.util.List;

public class Question {
	
	private String title;
	private List<String> options;
	
	public Question(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}
	
	public Question(String title) {
		this(title, Collections.<String>emptyList());
		                // 빈 리스트를 반환  => 제네릭  메소드
	}
	
	public String getTitle() {
		return title;
	}

	public List<String> getOptions() {
		return options;
	}

	public boolean isChoice() {
		return options!=null && !options.isEmpty();
	}
	
	
}
