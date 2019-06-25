package com.osf.web.controller;

import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.ejb.criteria.expression.function.TrimFunction;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.osf.web.dao.ntDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@Transactional
public class NaverTranslationController {

	@Autowired
	private ntDAO ntdao;
	
	@GetMapping("/translations")
	public @ResponseBody List<Map<String,Object>> getTranslation(){
		return ntdao.selectList();
	}
	 
	@GetMapping("/translation/{target}/{source}/{text}")
	public @ResponseBody Object doTranslation(@PathVariable("target") String target, 
			@PathVariable("source") String source, 
			@PathVariable("text") String text) {
		Map<String,Object> iMap = new HashMap<String, Object>();
		
		log.info("target=>{},source=>{},text=>{}", new String[] {target,source,text});
		Map<String,String> param = new HashMap<String, String>();
		param.put("target", target);
		param.put("source", source);
		param.put("text", text);
		
		
		
		
		
		if(ntdao.selectTranslationHisOne(param)==null) {
			Map<String,Object> pMap = (Map<String, Object>) translationTest(target, source, text).get("message");
			Map<String,Object> rMap = (Map<String, Object>) pMap.get("result");
		
			iMap.put("req", text);
			iMap.put("target", param.get("target"));
			iMap.put("source", param.get("source"));
			iMap.put("text", param.get("text"));
			if(rMap.get("errorCode")!=null) {
				iMap.put("error", rMap.get("errorCode"));
			}else {
				iMap.put("error", "");	
			}
			ntdao.insertTranslation(iMap);
			return ntdao.selectTranslationHisOne(param);
			
		}else {
			
			Map<String,Object> result = ntdao.selectTranslationHisOne(param);
			Map<String,Object> numMap = new HashMap<String,Object>();
			numMap.put("thNum", result.get("TH_NUM"));
			if(numMap.get("thNum")!=null) {
			ntdao.updateTc(numMap);
			}
			return result;
			
		}
	}
	
	private Map<String,Object> translationTest(String target, String source, String text) {
		   String clientId = "7hBtthi838kriEiykhju";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "Aad2suujdW";//애플리케이션 클라이언트 시크릿값";
	        Map<String,Object> rMap = new HashMap<String,Object>();
	        try {
				text = URLEncoder.encode(text,"UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try {
	            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("POST");
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	            
	            // post request
	            String postParams = "source=" + source + "&target=" + target +"&text="+text;
	            con.setDoOutput(true);
	            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	            wr.writeBytes(postParams);
	            wr.flush();
	            wr.close();
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	            	br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            	
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	                
	            }
	            br.close();
	            ObjectMapper om = new ObjectMapper();
	            rMap = om.readValue(response.toString(), Map.class);
	            log.info("resMap=>{}",rMap);
	            return rMap;
	        } catch (Exception e) {
	            log.error("error=>{}",e);
	        }
	        return null;
	}
}
