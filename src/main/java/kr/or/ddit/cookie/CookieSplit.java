package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.jsp.MulCalculation;

public class CookieSplit {
	
	private static final Logger logger = LoggerFactory.getLogger(MulCalculation.class);
	
	// cookieString 문자열 별수에 담긴 값은
	// 쿠키이름1=쿠키값1; 쿠키이름2=쿠키값2; .....
	// 구성된 쿠키 이름과 값은 상황에 따라 변경될 수 있음
	private String cookieString = "USERID=brown; REMEMBERME=Y; TEST=T";
	public static void main(String[] args) {
		
		CookieSplit cookieSplit = new CookieSplit();
		logger.debug(cookieSplit.getCookieValue("USERID")); // 기대되는 값 brown
		logger.debug(cookieSplit.getCookieValue("REMEMBERME")); // 기대되는 값 Y
		logger.debug(cookieSplit.getCookieValue("TEST")); // 기대되는 값 T
		logger.debug(cookieSplit.getCookieValue("XXXX")); // 기대되는 값 ""(WHITE SPACE)
	}
	
	// cookieString 필드를 분석하여 메소드 인자로 넘어온 cookieName에 해당하는 쿠키가 있을 경우
	// 해당 쿠키의 값을 반환하는 메소드
	public String getCookieValue(String cookieName) {
		
		String[] cookies = cookieString.split("; "); // 쿠키를 나누고
		
		for(int i=0; i<cookies.length; i++) {
			String[] cookie = cookies[i].split("="); // 쿠키 하나를 쪼개고
			if(cookie[0].equals(cookieName)) {
				String cookieValue = cookie[1];
				return cookieValue;
			}
		}
		return "";
	}

}
