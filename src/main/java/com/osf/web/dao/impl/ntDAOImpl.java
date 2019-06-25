package com.osf.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.osf.web.dao.ntDAO;

@Repository
public class ntDAOImpl implements ntDAO {
	
	@Autowired
	private SqlSession ss;
	
	@Override
	public List<Map<String, Object>> selectList() {
		
		return ss.selectList("naver.selectList");
	}

	@Override
	public Map<String, Object> selectTranslationHisOne(Map<String, String> param) {
		return ss.selectOne("naver.selectOne",param);
		
	}

	@Override
	public Integer insertTranslation(Map<String, Object> param) {
		
		return ss.insert("naver.insertTranslate",param);
	}

	@Override
	public Integer updateTc(Map<String, Object> param) {
		return ss.update("naver.updateTranslate",param);
	}
}
 