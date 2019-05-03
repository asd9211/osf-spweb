package com.osf.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osf.web.dao.AddrDAO;
import com.osf.web.service.AddrService;

@Service
public class AddrServiceImpl implements AddrService {
	@Autowired
	private AddrDAO adao;
	
	@Override
	public List<Map<String, String>> selectAddrList() {
		// TODO Auto-generated method stub
		return adao.selectAddrList();
	}

}
 