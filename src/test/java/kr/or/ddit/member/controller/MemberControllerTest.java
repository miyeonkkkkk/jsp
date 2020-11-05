package kr.or.ddit.member.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.InputStream;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;
import kr.or.ddit.member.service.MemberServiceI;

public class MemberControllerTest extends WebTestConfig {
	
	@Resource(name = "memberService")
	private MemberServiceI memberService;
	
	@Before
	public void setUp() throws Exception {
		memberService.deleteMember("kmy6");
	}

	@Test
	public void viewTest() throws Exception {

		mockmvc.perform(get("/member/memberListPage")).andExpect(status().isOk())
				.andExpect(view().name("member/memberList"));
	}

	@Test
	public void getMemberTest() throws Exception {
		MvcResult result = mockmvc.perform(get("/member/getMember").param("userid", "brown")).andReturn();

		ModelAndView mav = result.getModelAndView();

		assertEquals("member/member", mav.getViewName());
	}

	@Test
	public void getProfileTest() throws Exception {
		mockmvc.perform(get("/member/profileImg").param("userid", "brown"))
									.andExpect(status().isOk());
	}

	@Test
	public void profileDownloadTest() throws Exception {
		mockmvc.perform(get("/member/profileDownload").param("userid", "brown"))
										.andExpect(status().isOk());
	}

	@Test
	public void memberUpdateGetTest() throws Exception {
		mockmvc.perform(get("/member/memberUpdate").param("userid", "brown"))
								.andExpect(status().isOk());
	}

	@Test
	public void memberUpdatePostTest() throws Exception {
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/JJ2.png");
		
		MockMultipartFile file = new MockMultipartFile("rf", "JJ2.png", "image/png", is);
		
		
		mockmvc.perform(fileUpload("/member/memberUpdate")
									.file(file)
									.param("userid", "kmy2")
									.param("pass", "pass1234")
									.param("usernm", "유승호_수정")
									.param("alias", "유호호")
									.param("addr1", "대전 중구 중앙로 76")
									.param("addr2", "영민빌딩 404호")
									.param("zipcode", "34940"))
									.andExpect(view().name("redirect:/member/getMember?userid=kmy2"))
									.andExpect(status().is3xxRedirection());
		
	}

	@Test
	public void memberRegistGetTest() throws Exception {

		mockmvc.perform(get("/member/memberRegist")).andExpect(status().isOk())
				.andExpect(view().name("member/memberRegist"));
	}

	@Test
	public void memberRegistPostTest() throws Exception {
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/JJ2.png");
		
		MockMultipartFile file = new MockMultipartFile("rf", "JJ2.png", "image/png", is);
		
		// 객체 자체를 파라미터로 넘기는 건 불가능하다.
		mockmvc.perform(fileUpload("/member/memberRegist")
				.file(file)
				.param("userid", "kmy6")
				.param("pass", "pass1234")
				.param("usernm", "유승호_등록")
				.param("alias", "유호호")
				.param("addr1", "대전 중구 중앙로 76")
				.param("addr2", "영민빌딩 404호")
				.param("zipcode", "34940"))
				.andExpect(view().name("redirect:/member/memberListPage"))
				.andExpect(status().is3xxRedirection());
	}

}
