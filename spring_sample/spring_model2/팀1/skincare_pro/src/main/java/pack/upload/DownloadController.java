package pack.upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DownloadController {
	
	@RequestMapping("download")
	@ResponseBody  // 파일은 해석할 능력이 없어서 다운로드로 됨.
	public byte[] getDownloadFile(HttpServletResponse response,
									@RequestParam String filename) throws IOException {
		
		System.out.println("filename : " + filename);
		
		File file = new File("c:/work/upload/" + filename);
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		
		// 한글처리
		String fn = new String(file.getName().getBytes(), "iso_8859_1");
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fn + "\"");
		response.setContentLength(bytes.length);
		return bytes;
	}
	
}
