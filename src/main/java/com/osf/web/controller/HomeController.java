package com.osf.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
		@Autowired 
		private DataSource ds;
		@RequestMapping("/")
		public String goHome() {
			try {
				log.info("con=>{}", ds.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "index";
		}
		@RequestMapping("/test")
		public String goTest(Model model) { //모델은 리퀘스트의 어트리뷰트 같은존재. 뷰단까지 키값을 전달해줌.
			try {
				log.info("con=>{}", ds.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.addAttribute("msg", "hello~"); 
			
			List<String> strList = new ArrayList<String>();
			strList.add("1");
			strList.add("1");
			strList.add("1");
			model.addAttribute("list",strList);
			return "test";
			
		}
		
}
