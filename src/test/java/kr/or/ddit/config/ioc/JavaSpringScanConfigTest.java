package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
// 자바 파일이기 때문에 classes 를 사용한다.
@ContextConfiguration(classes = {JavaSpringScanConfig.class})
public class JavaSpringScanConfigTest {
	
	@Resource(name = "boardRepository")
	private BoardRepositoryI boardReopository;
	
	@Resource(name = "boardService")
	private BoardServiceI boardService;

	// boardRepository, boardService 스프링 빈이 정상적으로 등록 되었는지 확인
	
	//@Ignore
	@Test
	public void beanTest() {
		/***Given : 주어진 상황 기술 ***/

		
		/***When : 행위 ***/
		BoardVo boardVo = boardService.getBoard(1);

		
		/***Then : 결과 ***/
		assertNotNull(boardReopository);
		assertNotNull(boardService);
		assertEquals("내용", boardVo.getContent());
	}

}
