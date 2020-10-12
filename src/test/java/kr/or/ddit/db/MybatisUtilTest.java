package kr.or.ddit.db;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisUtilTest {

	@Test
	public void getSqlSession() {
		
		/***Given : 주어진 상황 기술 ***/

		/***When : 행위 ***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		/***Then : 결과 ***/
		assertNotNull(sqlSession);
	}

}
