package com.osf.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osf.web.dao.CmDAO;

@Repository
public class CmDAOImpl implements CmDAO {
	
	@Autowired
	private SqlSession ss;
	
	
	@Override
	public List<Map<String, String>> selectList() {
		return ss.selectList("cm.selectCmList");

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
