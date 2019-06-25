package com.osf.web.dao;

import java.util.List;
import java.util.Map;

public interface ntDAO {
	
	List<Map<String,Object>>selectList();
	Map<String,Object> selectTranslationHisOne(Map<String,String> param);
	Integer insertTranslation(Map<String,Object> param);
	Integer updateTc(Map<String,Object> param);
}
