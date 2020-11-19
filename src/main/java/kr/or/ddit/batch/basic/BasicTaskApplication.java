package kr.or.ddit.batch.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicTaskApplication {

	// 배치를 실행시킨다.
	public static void main(String[] args) {
		// batch-task-context.xml 을 이용하여 스프링 컨테이너를 생성
		ApplicationContext context =
					new ClassPathXmlApplicationContext("classpath:kr/or/ddit/config/spring/batch-task-context.xml");
		
	}

}
