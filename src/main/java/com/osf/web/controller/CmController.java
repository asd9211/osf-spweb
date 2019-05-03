package com.osf.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.osf.web.service.CmService;

@Controller
public class CmController {

	@Autowired
	private CmService cs;
	
	@RequestMapping(value="/cm/list",method=RequestMethod.GET) 
	public String goAddrList(Model m) {
		m.addAttribute("cmList", cs.selectList());
		return "/cm/list";

	}
}