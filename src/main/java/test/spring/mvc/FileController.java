package test.spring.mvc;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/file/*")
@Controller
public class FileController {
	
	@RequestMapping("uploadForm")
	public String uploadForm() {
		return "upload/uploadForm";
	}
	
	@RequestMapping("uploadPro")
	public String uploadPro(HttpServletRequest request, String writer, MultipartFile upload) {
		String filePath = request.getServletContext().getRealPath("/resources/file/");
	
		String contentType = upload.getContentType(); // mime type 확인
		//  / 자른값의 이미지가 0번째가 image면 업로드하겠다
		if(contentType.split("/")[0].equals("image")) {
			String orgName = upload.getOriginalFilename();
			String ext = orgName.substring(orgName.lastIndexOf(".")); 
			
			File copy = new File(filePath+writer+ext);
			try {
				upload.transferTo(copy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "upload/uploadPro";
	}
	
	// 업로드 한 번에 여러개 할 때 메서드
	@RequestMapping("uploadPro2")
	public String uploadPro2(String writer, ArrayList<MultipartFile> upload) {

		upload.forEach(f -> {
			// 저장되는 폴더
			String filePath = "d://file//";
			// 저장할 경로
			String orgName = f.getOriginalFilename();
			// 업로드할 위치?
			File copy = new File(filePath+orgName);
			try {
				// copy 에다 업로드를 해라
				f.transferTo(copy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} ); 
		return "upload/uploadPro";
	}
	
	
	
	
	
}