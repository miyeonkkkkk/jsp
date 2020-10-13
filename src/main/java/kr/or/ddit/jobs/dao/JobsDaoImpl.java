package kr.or.ddit.jobs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.jobs.model.JobsVO;

public class JobsDaoImpl implements JobsDaoI {
	
	private static JobsDaoI dao;
//	private SqlSession sqlSession;
	
	private JobsDaoImpl(){
//		sqlSession = MybatisUtil.getSqlSession();
	}
	
	public static JobsDaoI getDao() {
		if(dao == null) {
			dao = new JobsDaoImpl();
		}
		return dao;
	}

	@Override
	public List<JobsVO> selectAllJobs() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<JobsVO> jobsList = sqlSession.selectList("jobs.selectAllJobs");
		
		sqlSession.close();
		
		return jobsList;
	}

}
