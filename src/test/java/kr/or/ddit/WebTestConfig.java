package kr.or.ddit;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:kr/or/ddit/config/spring/root-context.xml",
									"classpath:kr/or/ddit/config/spring/application-context.xml",
									"classpath:kr/or/ddit/config/spring/datasource-context_dev.xml" })
@WebAppConfiguration // 스프링 컨테이너를 웹기반에서 동작하는 컨테이너로 생성하는 옵션(@Controller, @RequestMapping)
public class WebTestConfig {

	// 테스트 대상 클래스 : LoginController
	// --> MemberService
	// --> MemberRepository
	// 부모컨테이너와 자식컨테이너로 나누어져 있기 때문에 두개다 모두 가져와야 한다.
	// LogintController 스프링 빈을 생성하기 위해서 MemberService, MemberRepository 스프링 빈이 필요
	// 즉 service, repository 빈을 스캔하는 설정과 controller를 스캔하는 설정 두개가 필요

	// 스프링 프레임워크의 컨트롤로 테스트 시나리오
	// 1. 웹기반의 스프링 컨테이너를 구성 후
	// 2. dispatcherServlet 역할을 하는 객체를 생성 => MockMvc 생성
	// 3. dispatcherServlet 역할을 하는 객체를 통해 url, 파라미터 등을 첨부하여 요청 전송
	// 4. 응답이 원하는 형태로 나오는 체크(viewName, model에 담긴 속성)

	// 웹기반에서 돌아가는 applicationContext -> 스프링 컨테이너다.
	// DI / Autowired : 타입으로 주입할 객체를 찾는다. -> 타입이 한개일 경우 문제가 발생하지 않는다.
	@Autowired
	private WebApplicationContext wac;

	protected MockMvc mockmvc; // = dispatcherServlet
	
	@Resource(name = "dataSource")
	private DataSource dataSource;

	// @Before(setup()) => @Test => @After(tearDown())

	@Before
	public void setup() {
		// MockMvc 생성
		mockmvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScripts(new ClassPathResource("/kr/or/ddit/config/db/initData.sql"));
		populator.setContinueOnError(false); // 에러가 발생했을 때 테스트를 계속 진행 할거냐 , 스크립트 실행중 에러 발생시 멈춘다.
		DatabasePopulatorUtils.execute(populator, dataSource);
	}

	//get(), post() : get/post 요청
	//param(파라미터명, 파라미터값) : 요청시 보낼 파라미터
	
	//status() : 스프링 프레임워크에 의해 요청이 처리되고 생성된 응답 코드
	//view() : 스프링 프레임워크에 의해 요청이 처리되는 과정에서 반환된 viewName
	//model() : 컨트롤러에서 설정한 속성값을 담는 객체
	//request() : 요청 객체
	
	@Ignore
	@Test
	public void test() {
		
	}

}
