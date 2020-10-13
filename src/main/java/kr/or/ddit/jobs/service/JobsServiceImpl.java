package kr.or.ddit.jobs.service;

import java.util.List;

import kr.or.ddit.jobs.dao.JobsDaoI;
import kr.or.ddit.jobs.dao.JobsDaoImpl;
import kr.or.ddit.jobs.model.JobsVO;

public class JobsServiceImpl implements JobsServiceI {
	
	private static JobsServiceI service;
	private JobsDaoI dao;
	
	private JobsServiceImpl(){
		dao = JobsDaoImpl.getDao();
	}
	
	public static JobsServiceI getService() {
		if(service == null) {
			service = new JobsServiceImpl();
		}
		return service;
	}

	@Override
	public List<JobsVO> selectAllJobs() {
		
//		JobsDaoI dao = new JobsDaoImpl();
		
		return dao.selectAllJobs();
	}
	

}
