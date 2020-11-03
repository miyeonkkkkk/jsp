package kr.or.ddit.config.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.repository.BoardReopositoryImpl;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardServiceImpl;

@Configuration
public class JavaSpringConfig {
	
	// boardRepository, boardService
	// 메소드이름 ==> 스프링 빈이름
	
	// xml : <bean id="boardRepository(메소드 이름)" class="BoardReopositoryImpl" />
	@Bean
	public BoardRepositoryI boardRepository() {
		// new 연산자를 사용한다고 해서 여러개의 객체를 생성하는 것이 아니다. => 우리 눈에만 그렇게 보이는 것뿐이다.
		// 스프링 컨테이너가 읽어 실행하는 것이기 때문에 객체 생성은 한번만 되면 같은 객체가 return 된다.
		return new BoardReopositoryImpl();
	}
	
	// xml : <bean id="boardService(메소드 이름)" class="BoardServiceImpl" />
	@Bean
	public BoardServiceImpl boardService() {
		BoardServiceImpl boardService = new BoardServiceImpl();
		boardService.setBoardRepository(boardRepository());
		
		// 아래와 같이 직접 new 연산자를 통해 생성한 객체는 스프링 빈이 아니다.
		// @Bean 어노테이션이 붙은 메소르들 호출해야 스프링 컨테이너에서 관리되는 스프링빈을 얻을 수 있다.
		// boardService.setBoardRepository(new BoardReopositoryImpl());
		return boardService;
	}

}
