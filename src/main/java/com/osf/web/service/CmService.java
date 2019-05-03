package com.osf.web.service;

import java.util.List;
import java.util.Map;

public interface CmService {
	public List<Map<String,String>> selectList();
	public int insertCm(Map<String,String> cm);
	public int updateCm(Map<String,String> cm);
	public int deleteCm(Map<String,String> cmd);
}
