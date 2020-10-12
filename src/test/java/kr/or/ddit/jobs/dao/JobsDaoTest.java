package kr.or.ddit.jobs.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.model.JobsVO;

public class JobsDaoTest {

	@Test
	public void selectAllJobs() {
		/***Given : 주어진 상황 기술 ***/
		JobsDaoI dao = new JobsDaoImpl();

		/***When : 행위 ***/
		List<JobsVO> jobsList = dao.selectAllJobs();

		/***Then : 결과 ***/
		assertEquals(19, jobsList.size()); // 약식 비교
	}

}
