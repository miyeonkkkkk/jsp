package kr.or.ddit.member.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberVoValidator implements Validator {

	// 검증하려고 하는 객체가 MemberVoValidator 에서 검증이 가능한
	// 객체인지 boolean으로 리턴하는 메소드
	@Override
	public boolean supports(Class<?> clazz) {
		// memberVo와 관련된 객체인지 MemberVO클래스 정보를 통해 알려준다.
		return MemberVO.class.isAssignableFrom(clazz);
	}

	// 검증 로직을 작성하는 메소드
	// Object target : command 객체 - validator 파라미터 바로 앞에 있는 객체
	@Override
	public void validate(Object target, Errors errors) {
		MemberVO memberVo = (MemberVO)target;
		
		// usernm 사용자 이름 검사
		// usernm 값이 null이거나 empty 문자열이면 안된다.
		if(memberVo.getUsernm() == null || memberVo.getUsernm().equals("")) {
			errors.rejectValue("usernm", "required"); // errorCode는 개발자가 지정
		}
		
	}

}
