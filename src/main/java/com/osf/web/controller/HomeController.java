package com.osf.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

		@RequestMapping("/")
		public String goHome() {
			return "index";
		}
		@RequestMapping("/test")
		public String goTest(Model model) { //모델은 리퀘스트의 어트리뷰트 같은존재. 뷰단까지 키값을 전달해줌.
			model.addAttribute("msg", "hello~"); 
			
			List<String> strList = new ArrayList<String>();
			strList.add("1");
			strList.add("1");
			strList.add("1");
			model.addAttribute("list",strList);
			return "test";
			
		}
}
