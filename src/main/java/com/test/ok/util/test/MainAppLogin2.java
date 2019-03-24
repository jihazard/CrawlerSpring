package com.test.ok.util.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainAppLogin2 {
	private static String URL = "https://magandacafe.com/bbs/board.php?bo_table=freeboard&wr_id=1464488";
	private static String URL_LOGIN = "https://magandacafe.com/login_check.php";
	private static String login_id= "javaland";
	private static String login_pw= "wkqkfosem";
	private static Map<String , String> cookie;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//1.로그인 
		Response login = (Response) Jsoup.connect(URL_LOGIN)
				.data("login_id", login_id)
				.data("login_pw", login_pw)
				.method(Method.POST)
				.execute();
		System.out.println("page Status CODE" +login.statusCode() +"//" + login.statusMessage());
		Document doc = login.parse();
		//System.out.println("" +doc.toString());
		
		cookie = login.cookies();
		
		Document doctt=Jsoup.connect(URL).cookies(cookie).get();
		
		System.out.println(""+doctt.toString());
		
		
		/*
		String param = getParam(1);
		System.out.println("가져온 유아엘 " + URL+param);
		
		//1도큐먼트를 가져온다.
		Document doc = docAppend1to10(3);
		
		List<CrData> list = getElement(doc);
		
		System.out.println("사이즈 : " + list.size());
		int i=0;
		//배열에서 정보를 가져온다.
		for (CrData crData : list) {
			System.out.println(crData.toString());
		}*/
	}
	
	

	/**
	 *  
	 * @param param
	 * @return
	 * @throws IOException
	 */
	public static Document docAppend1to10(int param) throws IOException {
		Document doc = Jsoup.connect(URL+getParam(1)).get();
		//System.out.println(" "+ doc);
		for (int i = 2; i <= param; i++) {
		  Document doc2 = Jsoup.connect(URL+getParam(i)).get();
		  doc2.appendTo(doc);
		}
		return doc;
	}



	/**
	 * url 완성
	 * @param keyworkd
	 * @param page
	 * @return
	 */
	public static String getParam(int page){
		String param = "pg="+page; 
		
		return param;
	}

}
