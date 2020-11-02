package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.person.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/ioc/ioc.xml"})
public class IocDITest {

	// ioc.xml을 바탕으로 스프링 빈이 잘 생성되었는지 확인
	// setter - boardService, constructor - boardServiceC 주입 확인
	
	// DI
	// 스프링 빈중에 호환되는 타입의 빈이 있을 때 주입
	@Autowired
	ApplicationContext context; // 스프링 컨테이너 객체를 얻어온다(주입한다.) -> juni에서 사용하기 위해
	
	@Resource(name = "boardServiceC")
	BoardServiceImpl boardServiceC;
	
	@Resource(name = "boardService")
	BoardServiceImpl boardService;
	
	@Resource(name = "person")
	Person person;
	
	// person 스프링 빈의 age(value), boardRepository(ref) 두 속성에 주입이 잘 되었는지 확인
	@Test
	public void valueRefTest() {
		/***Given : 주어진 상황 기술 ***/

		/***When : 행위 ***/

		/***Then : 결과 ***/
		assertEquals(30, person.getAge());
		assertNotNull(person.getBoardRepository());
		assertEquals("내용", person.getBoardRepository().getBoard(1).getContent());
	}
	
	// boardSErvice, boardServiceC 스프링빈에 주입한 boardRepository 스프링빈은
	// 동일한 빈이므로 두 객체의 getter 메소드를 통해 얻어온 boardRepository 객체는 동일해야 한다.
	// bean이라는 자체가 singleton 이므로 객체를 1개만 생성한다. 그래서 동일한 객체이다.
	@Test
	public void repositorySameTest() {
		/***Given : 주어진 상황 기술 ***/
		
		/***When : 행위 ***/

		/***Then : 결과 ***/
		assertEquals(boardServiceC.getBoardRepository(),boardService.getBoardRepository());
	}
	
	@Test
	public void dIAutowiredTest() {
		/***Given : 주어진 상황 기술 ***/
		
		/***When : 행위 ***/

		/***Then : 결과 ***/
		assertNotNull(boardServiceC);
	}
	
	// 스프링 컨테이너를 주입 받아 DL을 통해 boardService 스프링 빈이 제대로 생성되었는지 확인
	@Test
	public void dITest() {
		/***Given : 주어진 상황 기술 ***/
		
		/***When : 행위 ***/
		BoardServiceI boardService = context.getBean("boardService", BoardServiceI.class);
		BoardVo boardVo = boardService.getBoard(1);

		/***Then : 결과 ***/
		assertEquals("첫번째 글", boardVo.getTitle());
		
	}

}
