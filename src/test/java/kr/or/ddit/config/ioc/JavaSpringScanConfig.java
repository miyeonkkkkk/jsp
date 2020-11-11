package kr.or.ddit.config.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {"kr.or.ddit"}) -> member 부분까지 읽어버리기 때문에 오류가 난다.
@ComponentScan(basePackages = {"kr.or.ddit.board"})
public class JavaSpringScanConfig {

	
}
