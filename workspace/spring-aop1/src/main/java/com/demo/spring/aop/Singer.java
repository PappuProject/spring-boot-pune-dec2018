package com.demo.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class Singer implements Performer{

	@Override
	public void perform() {
		System.out.println("Singer is now Singing....");
		
	}

}
