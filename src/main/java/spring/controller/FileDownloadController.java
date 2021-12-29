package spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileDownloadController {
	
	private static String CURR_IMG_REPO_PATH = "c://spring";
	
	@RequestMapping("/download")
	public void download(@RequestParam("imgFileName") String imgFileName, HttpServletResponse response)throws Exception {
		String downFile = CURR_IMG_REPO_PATH+"\\"+imgFileName;
		File file = new File(downFile);
		OutputStream out = response.getOutputStream();
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName="+imgFileName);
		
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		
		while(true) {
			int cnt = fis.read(buffer);
			if(cnt == -1) {
				break;
			}
			out.write(buffer,0,cnt);
		}
		
		fis.close();
		out.close();
	}
	
}
