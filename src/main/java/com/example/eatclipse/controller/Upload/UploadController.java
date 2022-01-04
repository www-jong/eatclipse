package com.example.eatclipse.controller.Upload;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

	//첨부파일을 저장할 디렉토리
	@Resource(name="upload_path")  // bean 객체에 대한 id값
	String upload_path;
	//String upload_path="c:/upload"; 이거와 같은 의미. 경로의 유출을 막기위해 사용
	
	@RequestMapping("/upload/input.do")  // 매핑url값과 메서드를 연결
	public String input() {
		return "upload/input"; //   views/upload/input.jsp
	}
	
	@RequestMapping("/upload/upload.do")
	public ModelAndView uploadForm(MultipartFile file,ModelAndView mav) 
	throws Exception{ 
		//MultipartFile : 여러개의 파일을 담을 수 있는 컬렉션
		//첨부파일의 이름
		String savedName = file.getOriginalFilename();
		
		//파일 이름이 중복되지 않도록 설정하는 방법 : UUID 국제통용고유식별값
		/*
		 * MultipartRequest multi=new MultipartRequest(
		 *                        request,
		 *                        실제저장소,
		 *                        파일의 크기,
		 *                        인코딩타입("utf-8"),
		 *                        new FileNamePoli...() --> 파일이름 중복안되게 처리해주던거
		 * );
		 */
		savedName=uploadFile(savedName,file.getBytes());
		
		mav.setViewName("upload/upload_result");
		
		// 출력페이지로 전달될 변수
		mav.addObject("saved_name",savedName);
		
		return mav;
	}
	// UUID 처리용 
	public String uploadFile(String originalName, byte[] fileData) 
	throws Exception{
		// uuid 생성 = universal unique Identifier의 약자
		UUID uid=UUID.randomUUID();
		String savedName=uid.toString()+ "_" + originalName;
		//abc.txt 이게 중복되면 asds_abc.txt 이런식으로 생성
		File target= new File(upload_path,savedName);
		FileCopyUtils.copy(fileData, target);  // 파일복사작업
		return savedName;
	}
}
