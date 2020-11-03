package kr.or.ddit.config.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateStringConverter implements Converter<String, Date>{

	// 프레임 워크에서 호출 -> 사용자가 직접호출 안함
	@Override
	public Date convert(String source) {
		Date date = null;
		
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}


}
