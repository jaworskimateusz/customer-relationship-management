package ff.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* ff.controller.*.*(..))")
	public void forController() {}
	
	@Pointcut("execution(* ff.dao.*.*(..))")
	public void forDao() {}
	
	@Pointcut("execution(* ff.service.*.*(..))")
	public void forService() {}
	
	@Pointcut("forController() || forDao() || forService()")
	public void forApplication() {}
	
	@Before("forApplication()")
	public void before(JoinPoint joinPoint) {
		logger.info("\n\n---->" + joinPoint.getSignature().toShortString());
	}
	
	@AfterReturning(pointcut = "forApplication()", returning="result")
	public void afterReturninig(JoinPoint joinPoint, Object result) {
		logger.info("\n\n---->" + joinPoint.getSignature().toShortString());
		logger.info("\n\n---->" + result);
	}
	
}
