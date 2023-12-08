package test.spring.mvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// AOP�� �߻����� �� �� �κ��� ����ǰ� �ϰڴ�
@Aspect
@Component
public class TestAdvice {

	@Around("execution(* test.spring.mvc.service.AopService*.*(..))")
	public Object around(ProceedingJoinPoint jp) {
		Object obj = null;
		try {
			System.out.println("=======[ aop around 111 ] =======");
			obj = jp.proceed();
			System.out.println("=======[ aop around 222 ] =======");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	// ���������� , ����Ÿ�� , ��Ű�� , Ŭ������ , �޼����() , ����
    // 	@Before("execution(public void test.spring.mvc.TestController.main(..) Exception)")	
	
	
	@Before("execution(* test.spring.mvc.service.AopService*.*(..))")
	public void beforeAdvice() {
		System.out.println("====== AOP BEFORE ======");
	}
	
	@After("execution(* test.spring.mvc.service.AopService*.*(String))")
	public void AfterAdvice() {
		System.out.println("====== AOP AFTER ======");
	}
}
