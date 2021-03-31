package com.satelite54.usetrading.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(value = "com.satelite54.usetrading.aop.*")
@Configuration
@EnableAspectJAutoProxy
public class SampleAspectConfig {
	
	@Bean
	SampleAopBean sampleAopBean() {
		return new SampleAopBean("this is AspectJ bean");
	}
	
	@Bean
	SampleAspect sampleAspect() {
		return new SampleAspect();
	}
}
