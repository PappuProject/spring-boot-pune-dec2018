package com.demo.spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {

	@Pointcut("execution(* com.demo.spring.aop.Performer.perform(..))")
	private void pcut() {}
	
	@Before("pcut()")
	public void switchOffMobile() {
		System.out.println("The Audience is switching of mobiles...");
		
	}
	
	@Before("pcut()")
	public void takeSeat() {
		//System.out.println("The Audience is seating now...");
		throw new RuntimeException("Why switch Off Mobile....");
	}
	
	@AfterReturning("pcut()")
	public void applaud() {
		System.out.println("very good singing..Clap!Clap!Clap!");
	}
}
