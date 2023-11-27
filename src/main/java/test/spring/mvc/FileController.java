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
	
		String contentType = upload.getContentType(); // mime type Ȯ��
		//  / �ڸ����� �̹����� 0��°�� image�� ���ε��ϰڴ�
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
	
	// ���ε� �� ���� ������ �� �� �޼���
	@RequestMapping("uploadPro2")
	public String uploadPro2(String writer, ArrayList<MultipartFile> upload) {

		upload.forEach(f -> {
			// ����Ǵ� ����
			String filePath = "d://file//";
			// ������ ���
			String orgName = f.getOriginalFilename();
			// ���ε��� ��ġ?
			File copy = new File(filePath+orgName);
			try {
				// copy ���� ���ε带 �ض�
				f.transferTo(copy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} ); 
		return "upload/uploadPro";
	}
	
	
	
	
	
}