package com.ssafy.di.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component // 빈 등록
@Aspect // 공통 코드를 모아놓은 모듈
public class LoggingAspect {

	// DAO, Service의 모든 메소드가 호출되기 전에 로그찍기
	// @Before(value = "execution(* com.ssafy.di.model.CityDaoImpl.selectAll())" )
	// 모든 모델 패키지 아래의 모든 클래스의 모든 메소드
	@Before(value = "execution(* com.ssafy.di.model..*.*(..))")
	public void logging(JoinPoint jp) {
		System.out.printf("메소드의 선언부 : %s, 전달 파라미터 : %s", jp.getSignature(), Arrays.toString(jp.getArgs()));
	}
	
	@Around(value = "execution(* com.ssafy.di.model..*.*(..))")
	public Object executeTime(ProceedingJoinPoint pjp) throws Throwable
	{
		long start = System.currentTimeMillis();
		
		//원래의 메소드를 수행하는 코드
		Object result = pjp.proceed();
		
		System.out.println("메소드 수행시간 : " + (System.currentTimeMillis() - start));
		
		return result;
	}
}
