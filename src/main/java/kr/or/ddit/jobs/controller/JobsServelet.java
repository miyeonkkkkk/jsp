package kr.or.ddit.jobs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jobs.model.JobsVO;
import kr.or.ddit.jobs.service.JobsServiceI;
import kr.or.ddit.jobs.service.JobsServiceImpl;

@WebServlet("/jobsServelet")
public class JobsServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private JobsServiceI service;
	
	@Override
	public void init() throws ServletException {
		service = JobsServiceImpl.getService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		JobsServiceI service = new JobsServiceImpl();
		
		List<JobsVO> jobsList = service.selectAllJobs();
		
		request.setAttribute("jobsList", jobsList);
		
		request.getRequestDispatcher("/jobs/selectAlljobs.jsp").forward(request, response);
	}


}
