package kr.or.ddit.batch.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class BasicProcessor implements ItemProcessor<String, String> {
	
	private static final Logger logger = LoggerFactory.getLogger(BasicProcessor.class);

	@Override
	public String process(String item) throws Exception {
		logger.debug("======= process() ========");
		logger.debug("process : {}, {}", item, item + "_modified");
		
		// reader에서 읽은 데이터가 인자로 들어온다.
		// 들어온 데이터를 가공해서 return
		return item + "_modified";
	}

}
