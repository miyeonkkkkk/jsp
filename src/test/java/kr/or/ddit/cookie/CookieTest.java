package kr.or.ddit.cookie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CookieTest {

	@Test
	public void getCookieValueTest() {
		
		/***Given : 주어진 상황 기술 ***/
		CookieSplit cookieSplit = new CookieSplit();

		/***When : 행위 ***/
		String cookieValue = cookieSplit.getCookieValue("TEST");
		
		/***Then : 결과 ***/
		assertEquals("T", cookieValue); // 기대값, 실제값
		
	}
	
	@Test
	public void getCookieValueTeste() {
		
		/***Given : 주어진 상황 기술 ***/
		CookieSplit cookieSplit = new CookieSplit();

		/***When : 행위 ***/
		String cookieValue = cookieSplit.getCookieValue("USERID2");
		
		/***Then : 결과 ***/
		assertEquals("", cookieValue); // 기대값, 실제값
		
	}
}
