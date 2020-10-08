package kr.or.ddit.member.dao;

import kr.or.ddit.member.model.MemberVO;

public interface MemberDaoI {
	
	/**
	 * 회원 한명의 정보를 조회하는 메서드
	* MemberDaoI.java
	*
	* @author PC-04
	* @version 1.0
	* @see
	*
	* <pre>
	* << 개정이력(Modification Information) >>
	*
	* 수정자 수정내용
	* ------ ------------------------
	* PC-04 최초 생성
	*
	* </pre>
	 */
	public MemberVO getMember(String userId);

}
