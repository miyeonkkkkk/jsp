package kr.or.ddit.fileUpload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtil {
	
	// form-data; name="img"; filename="aa.jpg"
	// ==> aa.jpg
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
	
	// 파일명을 추출하기 위한 메서드
	public static String getFileNameFromHeader(String contentDisposition) {
		String fileName = "";
		String[] cd_data = contentDisposition.split("; ");
		for (int i = 0; i < cd_data.length; i++) {
//			logger.debug(data[i]);
			String[] data = cd_data[i].split("=");
			if("filename".equals(data[0])) {
				fileName = data[1].replaceAll("\"", "");
				break;
			}
		}
		return fileName;
	}
	
	// filename : sally.png ==> png
	// 확장자를 추출하기 위한 메서드
	public static String getExtension(String filename) {
		
		if(filename == null || filename.indexOf(".") == -1) {
			return "";
		}else {
			// 정규화 표현으로 넣어야 한다.
			return filename.trim().split("\\.")[1];
		}
		
		
	}

}
