package kr.or.ddit.jobs.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.model.JobsVO;

public class JobsServiceITest {

	@Test
	public void selectAllJobs() {
		/***Given : 주어진 상황 기술 ***/
		JobsServiceI service = new JobsServiceImpl();

		/***When : 행위 ***/
		List<JobsVO> jobsList = service.selectAllJobs();

		/***Then : 결과 ***/
		assertEquals(19, jobsList.size()); // 약식 비교
	}

}
