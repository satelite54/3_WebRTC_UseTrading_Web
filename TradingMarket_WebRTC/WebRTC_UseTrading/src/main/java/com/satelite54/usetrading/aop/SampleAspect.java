package com.satelite54.usetrading.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SampleAspect {
	
	// 메소드의 실행 전에 삽입하는 처리임을 나타내는 어노테이션 @before와 유사
	@Before("execution(* com.satelite54.usetrading.aop.SampleAopBean.*(..))")
	public void before() {
		System.out.println("before:");
	}
	
	@After("execution(* ccom.satelite54.usetrading.aop.SampleAopBean.*(..))")
	public void after() {
		System.out.println("After:");
	}
}
