package spring.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FileUploadController {
	
	private static String CURR_IMG_REPO_PATH = "c://spring";
	
	@RequestMapping(value = "fileUpload", method = RequestMethod.GET)
	public String form() {
		return "fileUpload/fileUploadForm";
	}
	
	@RequestMapping(value = "fileUpload", method = RequestMethod.POST)
	public ModelAndView fileUpload(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		
		// 매개변수 정보와 파일 정보를 저장할 map(주로 파일을 여러개 전송할때 사용)
		Map map = new HashMap();
		
		Enumeration enu = request.getParameterNames();
		
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = request.getParameter(name); //파일 이름
			map.put(name, value); //파일에 이름만 저장
		}
		
		// 파일 업로드 후 반환된 파일 이름이 저장된 리스트를 다시 map에 저장
		List fileList = fileProcess(request);
		
		map.put("fileList", fileList);
		
		// map을 결과창에 포워딩
		ModelAndView mav = new ModelAndView();
		mav.addObject("map",map);
		mav.setViewName("fileUpload/fileUploadComplete"); // jsp파일을 어느경로에서 찾을것인가
		return mav;
		
	}

	private List fileProcess(MultipartHttpServletRequest request)throws Exception {
		// 업로드 된 파일을 저장하기 위한 메소드
		List<String> fileList = new ArrayList();
		
		// 첨부된 파일 이름을 가져온다.
		Iterator<String> fileNames = request.getFileNames();
		
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			
			// 파일 이름에 대한 MultipartFile 객체를 가져온다
			MultipartFile mfile = request.getFile(fileName);
		
			// 실제 파일 이름을 가져온다
			String originalFileName = mfile.getOriginalFilename();
			
			// 파일 이름을 하나씩 리스트에 저장
			fileList.add(originalFileName);
			
			File file = new File(CURR_IMG_REPO_PATH+"\\"+fileName);
			
			// 첨부된 파일이 있는지 체크
			if(mfile.getSize() !=0) { // 파일 null 체크
				if(file.getParentFile().mkdirs()) { // 파일 저장 경로에 해당하는 directory가 없는 경우 생성
					file.createNewFile(); // 이후에 파일 생성
				}
			}
			
			// 임시로 저장된 MultipartFile을 실제 파일로 전송
			mfile.transferTo(new File(CURR_IMG_REPO_PATH+"\\"+originalFileName));
		}
		// 첨부된 파일 이름이 저장된 리스트를 반환
		return fileList;
	}
	
	
}
