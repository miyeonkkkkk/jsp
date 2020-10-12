package kr.or.ddit.jobs.dao;

import java.util.List;

import kr.or.ddit.jobs.model.JobsVO;

public interface JobsDaoI {
	
	/**
	 * jobs 테이블의 모든 데이터를 조회하는 메소드
	* JobsDaoI.java
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
	public List<JobsVO> selectAllJobs();

}
