package crm.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* crm.controller.*.*(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* crm.service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* crm.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forApplication() {}
	
	@Before("forApplication()") 
	public void before(JoinPoint joinPoint) {
		logger.info("\n>>>>>@Before method: " + joinPoint.getSignature().toString() + "\n");
		Object [] args = joinPoint.getArgs();
		diplayArguments(args);
	}
	
	@AfterReturning(pointcut="forApplication()",
					returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("\n>>>>>@AfterReturning method: " + joinPoint.getSignature().toString() + "\n");
		logger.info("\n\n>>>>> result: " + result);
	}
	
	private void diplayArguments(Object [] args) {
		for(Object arg: args) {
			logger.info(">>>>> argument: " + arg);
		}
	}
}





