package com.satelite54.usetrading.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SampleAspect {
	
	@Before("execution(* com.satelite54.usetrading.aop.SampleAopBean.*(..))")
	public void before() {
		System.out.println("before:");
	}
	
	@After("execution(* ccom.satelite54.usetrading.aop.SampleAopBean.*(..))")
	public void after() {
		System.out.println("After:");
	}
}
