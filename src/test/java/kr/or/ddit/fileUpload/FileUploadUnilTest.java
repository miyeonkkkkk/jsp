package kr.or.ddit.fileUpload;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUnilTest {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUnilTest.class);

	@Test
	public void getFileNameFromHeader() {
		
		/***Given : 주어진 상황 기술 ***/
		String cd = "form-data; name=\"img\"; filename=\"aa.jpg\"";

		/***When : 행위 ***/
		String fileName = FileUploadUtil.getFileNameFromHeader(cd);

		/***Then : 결과 ***/
		assertEquals("aa.jpg", fileName);
	}
	
	@Test
	public void UUIDtest() {
		/***Given : 주어진 상황 기술 ***/
		
		/***When : 행위 ***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid : {} " , uuid);
		
		/***Then : 결과 ***/
	}
	
	// filename : sally.png ==> png
	// 확장자를 추출하기 위한 메서드
	@Test
	public void getExtensionTest() {
		/***Given : 주어진 상황 기술 ***/
		String filename = "sally.png";

		/***When : 행위 ***/
		String extension = FileUploadUtil.getExtension(filename);

		/***Then : 결과 ***/
		assertEquals("png", extension);
		
	}
	
	@Test
	public void getExtensionFailTest() {
		/***Given : 주어진 상황 기술 ***/
		String filename = "sally";

		/***When : 행위 ***/
		String extension = FileUploadUtil.getExtension(filename);

		/***Then : 결과 ***/
		assertEquals("", extension);
		
	}

}
