package com.osf.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osf.web.dao.CmDAO;
import com.osf.web.dao.impl.CmDAOImpl;
import com.osf.web.service.CmService;

@Service
public class CmServiceImpl implements CmService {
	@Autowired
	CmDAO cdao;
	
	@Override
	public List<Map<String, String>> selectList() {
		// TODO Auto-generated method stub
		return cdao.selectList();
	}

	@Override
	public int insertCm(Map<String, String> cm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCm(Map<String, String> cm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCm(Map<String, String> cmd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
