package test.spring.mvc;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file/*")
public class FileController {
	
	@RequestMapping("uploadForm")
	public String uploadForm() {
		return "upload/uploadForm";
	}
	
	@RequestMapping("uploadPro")
	public String uploadPro(HttpServletRequest request ,String writer, MultipartFile upload) {
		String filePath = request.getServletContext().getRealPath("/resources/file/");
		String contentType = upload.getContentType();
		
		if(contentType.split("/")[0].equals("image")) {
			String orgName = upload.getOriginalFilename();
			String ext = orgName.substring(orgName.lastIndexOf("."));
			File copy = new File(filePath + writer + ext);	//저장 장소만 생성
			try {
				upload.transferTo(copy);	//저장 장소에 원본 파일 저장
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "upload/uploadPro";
	}
	
	@RequestMapping("uploadPro2")
	public String uploadPro2(String writer, ArrayList<MultipartFile> upload) {
		upload.forEach(file -> {
			String filePath = "d://upload//file//";
			String orgName = file.getOriginalFilename();
			File copy = new File(filePath + orgName);	//저장 장소만 생성
			try {
				file.transferTo(copy);	//저장 장소에 원본 파일 저장
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return "upload/uploadPro";
	}
}
