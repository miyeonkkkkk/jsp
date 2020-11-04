package kr.or.ddit.fileupload.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.WebTestConfig;

public class FileUploadControllerTest extends WebTestConfig {

	@Test
	public void viewTest() throws Exception {

		/*** Given : 주어진 상황 기술 ***/

		/*** When : 행위 ***/
		mockmvc.perform(get("/fileupload/view")).andExpect(status().isOk()).andExpect(view().name("fileupload/fileupload"));

		/*** Then : 결과 ***/
	}
	
	@Test
	public void fileUploadTest() throws Exception {
		/*** Given : 주어진 상황 기술 ***/
//		String name, String originalFilename, String contentType, InputStream contentStream
		
//		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("kr/or/ddit/upload/JJ2.png");
//		FileInputStream fis = new FileInputStream("D:\\A_TeachingMaterial\\6.JspSpring\\workspace\\spring\\src\\test\\resources\\kr\\or\\ddit\\upload\\JJ2.png");
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/JJ2.png");
		
		MockMultipartFile file = new MockMultipartFile("file", "JJ2.png", "image/png", is);
		
		/*** When : 행위 ***/
		mockmvc.perform(fileUpload("/fileupload/upload")
									.file(file)
									.param("userid", "브라운"))
									.andExpect(status().isOk())
									.andExpect(view().name("fileupload/fileupload"));
		
		/*** Then : 결과 ***/
	}
	
	

}
