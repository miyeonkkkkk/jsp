package kr.or.ddit.batch.basic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class BasicWriter implements ItemWriter<String>{

	private static final Logger logger = LoggerFactory.getLogger(BasicWriter.class);
	
	@Override
	public void write(List<? extends String> items) throws Exception {
		// chunk에 설정된 값에 따라 처리되는 데이터 양이 달라지기 때문에 list로 관리된다.
		
		logger.debug("========== write ==========");
		logger.debug("items : {}", items);
		logger.debug("========== write ==========");
		
	}

}
