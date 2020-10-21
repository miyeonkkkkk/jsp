package kr.or.ddit.fileUpload;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileUploadUnil {

	@Test
	public void getFileNameFromHeader() {
		
		/***Given : 주어진 상황 기술 ***/
		String cd = "form-data; name=\"img\"; filename=\"aa.jpg\"";

		/***When : 행위 ***/
		String fileName = FileUploadUtil.getFileNameFromHeader(cd);

		/***Then : 결과 ***/
		assertEquals("aa.jpg", fileName);
	}

}
