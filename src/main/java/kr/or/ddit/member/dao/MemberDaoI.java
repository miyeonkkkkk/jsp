package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
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
	public List<MemberVO> selectAllMemberPage(SqlSession sqlSession,PageVO pv);
	
	/**
	 * 회원의 전체 수
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
	public int selectMemberTotalCnt(SqlSession sqlSession);

}
