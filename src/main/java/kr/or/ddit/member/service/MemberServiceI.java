package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public interface MemberServiceI {

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
	public MemberVO getMember(String userid);
	
	/**
	 * 회원 전체를 조회하는 메소드
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
	public List<MemberVO> selectAllMember();
	
	/**
	 * 회원 전체를 조회하는 메소드(페이징 처리 추가)
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
	public Map<String, Object> selectAllMemberPage(PageVO pageVo);
	
	/**
	 * 회원 정보를 등록하는 메서드
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
	public int insertMember(MemberVO mv);
	
	/**
	 * 회원 정보를 삭제하는 메서드
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
	public int deleteMember(String userid);
	
	/**
	 * 회원 정보를 수정하기 위한 메서드
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
	public int updateMember(MemberVO mv);

	

}
