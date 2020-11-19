package kr.or.ddit.batch.basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalendarTest {

	@Test
	public void test() {
		/***Given : 주어진 상황 기술 ***/
		String ym = "202011";
		
		/***When : 행위 ***/
		String y = ym.substring(0, 4);
		String m = ym.substring(4);
		
		/***Then : 결과 ***/
		assertEquals("2020", y);
		assertEquals("11", m);
	}

}
