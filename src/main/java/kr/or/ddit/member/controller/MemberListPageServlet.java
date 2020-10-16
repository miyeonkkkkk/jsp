package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/memberListPage")
public class MemberListPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberListPageServlet.class);
	
	private MemberServiceI memberService;
       
	public MemberListPageServlet(){
		memberService = new MemberServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HashMap<String, Integer> page = new HashMap<>();
//		page.put("page", 1);
//		page.put("pageSize", 7);
//		
//		List<MemberVO> mem = memberService.selectAllMemberPage(page);
//		System.out.println(mem.get(0).getUserid());
		
		// 현재 페이지
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		
		// 보여줄 페이지수
		String pageSize_str = request.getParameter("pageSize");
		int pageSize = pageSize_str == null ? 5 : Integer.parseInt(pageSize_str);
		
		// 현재 있는 페이지 정보를 저장
		request.setAttribute("page", page);
		request.setAttribute("pageSize", pageSize);
		
		// PageVO page, pageSize
		PageVO pv = new PageVO(page, pageSize);
		
		// memberService.selectMemberPageList(page) ==> List<MemberVO> ==> Map<String, Object>
		Map<String, Object> map = memberService.selectAllMemberPage(pv);
		
		// 전체 페이지수
		int totalCnt = (int)map.get("totalCnt");
		int pages = (int)Math.ceil((double)totalCnt/pageSize);
//		logger.debug("pgaeSize : {}",pageSize);
		
		request.setAttribute("memberList", map.get("memberList"));
		request.setAttribute("pages", pages);
		
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
	}


}
