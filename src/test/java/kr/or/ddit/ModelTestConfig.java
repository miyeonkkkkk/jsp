package kr.or.ddit;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

// repository + service : root-context.xml
// sqlSessionTemplate : dataSource-context.xml
// transaction : transaction-context.xml
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml",
								"classpath:kr/or/ddit/config/spring/datasource-context.xml",
								"classpath:kr/or/ddit/config/spring/transaction-context.xml" })
@WebAppConfiguration
public class ModelTestConfig {
	
	@Ignore
	@Test
	public void dummy() {
		
	}

}
