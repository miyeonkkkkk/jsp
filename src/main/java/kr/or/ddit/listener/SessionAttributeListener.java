package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;

public class SessionAttributeListener implements HttpSessionAttributeListener{

	private static final Logger logger = LoggerFactory.getLogger(SessionAttributeListener.class);
	
	// key : userid, value : MemberVO
	private Map<String, MemberVO> userMap = new HashMap<String, MemberVO>();
	
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
		// 로그인이 되었을 때 감지
		if("S_MEMBER".equals(event.getName())){
			logger.debug("attribute Add");
			logger.debug("사용자 로그인 했다잉");
			
			HttpSession session = event.getSession();
//			logger.debug("사용자 로그인 : {}" , ((MemberVO)session.getAttribute("S_MEMBER")).getUserid());
			
			// 속성에 추가된 값을 가져온다.
			MemberVO mv = (MemberVO)event.getValue();
			logger.debug("사용자 로그인 : {}" ,mv.getUserid());
			
			userMap.put(mv.getUserid(), mv);
			
			ServletContext sc = event.getSession().getServletContext();
			sc.setAttribute("userMap", userMap);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
		// 로그아웃 되었을 때 감지
		logger.debug("attribute Removed");
		
		if("S_MEMBER".equals(event.getName())) {
//			userMap에서 해당 사용자 정보 삭제
//			userMap.jsp에서 로그아웃한 사용자는 나오지 않는다.
			MemberVO mv = (MemberVO)event.getValue();
			userMap.remove(mv.getUserid());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		logger.debug("attribute Replaced");
		
	}

}
