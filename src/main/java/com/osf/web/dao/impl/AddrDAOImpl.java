package com.osf.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osf.web.dao.AddrDAO;

@Repository
public class AddrDAOImpl implements AddrDAO {
	
	@Autowired
	private static SqlSession ss;
	
	@Override 
	public List<Map<String, String>> selectAddrList() {
//		SqlSession ss = ssf.openSession();
		Map<String,String> param = new HashMap<String,String>();
		param.put("adNum", "20");
		param.put("adSido", "세종특별자치시");
		return ss.selectList("addr.selectAddrList", param);

	}
	public static void main(String[] args) {
		System.out.println(ss.selectList("addr.selectAddrList"));
	}

}
