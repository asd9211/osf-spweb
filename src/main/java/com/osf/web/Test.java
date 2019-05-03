package com.osf.web;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
	

	   public static void main(String[] args) {

	      String test=null;

	      if(test != null && test.equals("test")) {

	         log.info("test => {}",test);
	   }else {
		   
		   log.info("값이 일치하지 않습니다.");
	   }

	}
}
