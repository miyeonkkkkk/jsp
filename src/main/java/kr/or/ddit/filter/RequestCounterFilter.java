package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestCounterFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(RequestCounterFilter.class);
	Map<String, Integer> requestConterMap;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("RequestConterFilter.init()");
		// request(유효시간까지만), session(사용자마다), application(전체)

		requestConterMap = new HashMap<String, Integer>();
		
		ServletContext sc = filterConfig.getServletContext();
		sc.setAttribute("requestConterMap", requestConterMap);
		
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("RequestConterFilter.doFilter()");
		
		// filter에서 사용하는 request 타입이 다르기 때문에 형변환 하여 사용
		HttpServletRequest req = (HttpServletRequest)request;
		logger.debug("uri : {} ",req.getRequestURI());
		
		// uri별 요청 횟수
		// /memberList 12
		// /jstl/jstl_fmt_date.jsp 20
		// 어떤 자료구조를 쓰면 좋을까?
		// List, Set, Map
		
		// map객체에서 uri에 해당하는 요청이 있었는지 확인
		Integer value = requestConterMap.get(req.getRequestURI());
		
		if(value == null) {
			// 없으면 값을 1로 해서 새로운 key로 추가
			requestConterMap.put(req.getRequestURI(), 1);
		}else {
			// 있으면 기존 값에서 1을 더해 값을 수정
			requestConterMap.put(req.getRequestURI(), value + 1);
		}
		
		// 등록된 다른 필터로 요청을 위임
		// 만약 더이상 등록된 필터가 없을 경우 요청을 처리할 서블릿/jsp으로 요청을 전달
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}

}
