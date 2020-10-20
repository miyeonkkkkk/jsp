package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.debug("application init");
		ServletContext sc = sce.getServletContext();
		String cp = sc.getContextPath();
		
		sc.setAttribute("cp", cp);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
