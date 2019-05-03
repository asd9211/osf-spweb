package com.osf.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Exam {
public String name="11";

public static void main(String[] args) {
	/*
	 * Log4j  level순서 1. TRACE 2.DEBUG 3.INFO 4.WARN 5.ERROR 6.FATAL
	 * 
	 */
	String str ="홍길동";
	if(str.equals("홍길동")) {
		log.info("맞음");
	}else {
		log.info("아님");
	}
	log.warn("프로그램 비정상 종료,");
	
}
}
