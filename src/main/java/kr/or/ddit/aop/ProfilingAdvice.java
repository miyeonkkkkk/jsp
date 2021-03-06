package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ProfilingAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ProfilingAdvice.class);

	// pointCut 설정을 위한 의미 없는 메소드
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {

	}

	@Before("dummy()")
	public void beforeMethod(JoinPoint joinPoint) {
//		joinPoint.getSignature(); // 메소드에 대한 정보를 가져올 수있다.
		logger.debug("beforeMethod : {}", joinPoint.getSignature().getName());
	}

	@Around("dummy()")
	public Object aroundMethod(ProceedingJoinPoint joinPoin) throws Throwable {

		// 메소드 실행전 공통 관심사항
		long start = System.currentTimeMillis();

		// 메소드 실행
		// joinPoin.getArgs(); // 해당 핵심로직을 실행할 때 메소드 인자
		Object ret = joinPoin.proceed(joinPoin.getArgs()); // 메소드 실행

		// 메소드 실행후 공통 관심사항
		long end = System.currentTimeMillis();
		logger.debug("profiling : {} {} - {}", joinPoin.getSignature().getDeclaringTypeName(),
				joinPoin.getSignature().getName(), (end - start) + " ms");
		return ret;
		
	}

}
