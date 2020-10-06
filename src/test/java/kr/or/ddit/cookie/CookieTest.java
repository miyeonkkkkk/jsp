package kr.or.ddit.cookie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CookieTest {

	@Test
	public void getCookieValueTest(String cookieName) {
		
		/***Given : 주어진 상황 기술 ***/
		CookieSplit cookieSplit = new CookieSplit();

		/***When : 행위 ***/
		String cookieValue = cookieSplit.getCookieValue(cookieName);
		
		/***Then : 결과 ***/
		assertEquals(cookieValue, cookieValue); // 기대값, 실제값
		
	}
}
