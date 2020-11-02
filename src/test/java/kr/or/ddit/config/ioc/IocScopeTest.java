package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.repository.BoardRepositoryI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/ioc/scope.xml"})
public class IocScopeTest {
	
	@Autowired
	ApplicationContext context;
	
	@Resource(name = "boardRepository")
	private BoardRepositoryI boardReopository;
	
	@Resource(name = "boardRepository")
	private BoardRepositoryI boardReopository2;

	@Resource(name = "boardRepository_a")
	private BoardRepositoryI boardReopository_a;

	@Resource(name = "boardRepository_p")
	private BoardRepositoryI boardReopository_p;
	
	@Resource(name = "boardRepository_p")
	private BoardRepositoryI boardReopository_p2;
	
	private static final Logger logger = LoggerFactory.getLogger(IocScopeTest.class);

	@Test
	public void prototypeTest() {
		/***Given : 주어진 상황 기술 ***/
		

		/***When : 행위 ***/
		for(int i = 0; i < 10; i++) {
			BoardRepositoryI  boardRepository = context.getBean("boardRepository", BoardRepositoryI.class);

			BoardRepositoryI  boardRepositoryp = context.getBean("boardRepository_p", BoardRepositoryI.class);
			
			logger.debug("singleton-boardRepository : {}, prototype-boardRepository : {}", boardRepository, boardRepositoryp);
		}

		/***Then : 결과 ***/
		assertNotEquals(boardReopository_p, boardReopository_p2);
	}

	@Test
	public void singletonTest() {
		/***Given : 주어진 상황 기술 ***/
		
		
		/***When : 행위 ***/
		
		
		/***Then : 결과 ***/
		assertEquals(boardReopository, boardReopository2);
		assertNotEquals(boardReopository, boardReopository_a);
		assertNotEquals(boardReopository2, boardReopository_a);
	}
}
