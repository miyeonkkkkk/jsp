package kr.or.ddit.batch.basic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class BasicReader implements ItemReader<String> {
	
	private static final Logger logger = LoggerFactory.getLogger(BasicReader.class);
	
	// 다른 클래스에서도 사용
	private List<String> list;
	
	// 필드변수로 설정 했을 경우 기본값으로 초기화 한다.
	// 읽을 데이터를 인덱스 변수로 관리
	private int index = 0;
	
	public BasicReader() {
		// 생성자를 통해 한번만 생성
		// list 객체에 5개의 임의 값을 생성
		list = new ArrayList<String>(); 
		list.add("brown");
		list.add("sally");
		list.add("cony");
		list.add("moon");
		list.add("james");
	}

	// return 값이 Processor 에게 전달
	// 더이상 읽을 데이터가 없을 때 null을 리턴 ==> spring batch 모듈에게 읽을 데이터가 없다고 인식
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// 제네릭을 String 으로 하였기 때문에 return 타입입 String이다.
		
		logger.debug("======= read() ========");
		
		if(index < list.size()) {
			String item = list.get(index++);
			logger.debug("item : {}", item);
			return item;
		}else{
			index = 0;
			return null;
		}
	}

}
