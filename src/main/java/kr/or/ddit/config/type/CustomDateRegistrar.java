package kr.or.ddit.config.type;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomDateRegistrar implements PropertyEditorRegistrar{
	
	// CustomEditor를 등록시켜주는 메소드
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, 
				new CustomDateEditor(
						new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
