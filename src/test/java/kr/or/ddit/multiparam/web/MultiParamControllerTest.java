package kr.or.ddit.multiparam.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;

public class MultiParamControllerTest extends WebTestConfig {

	@Test
	public void viewTest() throws Exception {
		/***Given : 주어진 상황 기술 ***/
		MvcResult result = mockmvc.perform(get("/multi/view")).andReturn();
		
		ModelAndView mav = result.getModelAndView();
		
		/***When : 행위 ***/
		mockmvc.perform(get("/multi/view")).andExpect(status().isOk()).andExpect(view().name("multi/view"));

		/***Then : 결과 ***/
		assertEquals("multi/view", mav.getViewName());
	}
	
	@Test
	public void multiParamSubmitTest() throws Exception {
		MvcResult result = mockmvc.perform(get("/multi/submit").param("userid", "brown", "sally", "cony")).andDo(print()).andReturn();
		
		ModelAndView mav = result.getModelAndView();
		
		assertEquals("multi/view", mav.getViewName());
	}
	
	

}
