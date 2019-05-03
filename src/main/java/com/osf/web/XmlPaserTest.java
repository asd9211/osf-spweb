package com.osf.web;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.dbcp.BasicDataSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;





public class XmlPaserTest {

	public static void main(String[] args) {
		String path = "D:\\works\\osf-spweb\\src\\main\\resources\\spring\\application-config.xml";
		File f  = new File(path);
		DocumentBuilderFactory dBuildFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dBuildFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);
			Element root = doc.getDocumentElement();
			System.out.println(root.getAttribute("xsi:schemaLocation"));
			NodeList nodes = root.getElementsByTagName("bean"); //bean 태그들을 싹다 가져옴
			for(int i=0;i<nodes.getLength();i++) {
				Element bean = (Element) nodes.item(i);
				String id = bean.getAttribute("id");
				String className = bean.getAttribute("class");
				if("ds".equals(id)) {
					Class<?> clazz = Class.forName(className);
					Method[] methods = clazz.getDeclaredMethods();
					Object obj = clazz.newInstance();
					NodeList props = bean.getElementsByTagName("property");
					for(int j=0;j<props.getLength();j++) {
						Element prop = (Element) props.item(j);
						String methodName = prop.getAttribute("name");
						String value = prop.getAttribute("value");
						String fStr = methodName.substring(0, 1);
						methodName = "set" + fStr.toUpperCase() + methodName.substring(1);
						for(Method method:methods) {
							if(methodName.equals(method.getName())) {
								method.invoke(obj, value);
							}
						}
					}
					BasicDataSource bds = (BasicDataSource) obj;
					Connection con = bds.getConnection();
					System.out.println(con);
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
