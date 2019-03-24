package com.test.ok.util.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.test.ok.crwal.vo.CrData;

public class MyBlogTest {

	private static String URL = "https://jihazarrd.tistory.com/";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("가져온 유아엘 " + URL);
		
		//1도큐먼트를 가져온다.
		Document doc = docAppend1to10(3);
		//System.out.println(" " + doc.toString());
		List<CrData> list = getElement(doc);
		
		System.out.println("사이즈 : " + list.size());
		
		//배열에서 정보를 가져온다.
		for (CrData crData : list) {
			System.out.println(crData.toString());
		}
	}
	
	

	/**
	 *  
	 * @param param
	 * @return
	 * @throws IOException
	 */
	public static Document docAppend1to10(int param) throws IOException {
		Document doc = Jsoup.connect(URL).get();
		
		return doc;
	}


	/**
	 * @throws IOException 
	 * 
	 */
	public static List<CrData> getElement(Document doc) throws IOException {
		
		Elements subjects = doc.select(".post-item .title");
		Elements date = doc.select(".post-item a");
		
		
		List<CrData> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			//String subject, String url, String name, String date, String hit, String ok
			CrData crowl = new CrData(subjects.eq(i).text()
								 ,URL+ date.eq(i).attr("href")
								 ,"지하자드"
								 ,"블로그");
			
			list.add(crowl);
			
		}
		
		return list;
	}


	/**
	 * url 완성
	 * @param keyworkd
	 * @param page
	 * @return
	 */
	public static String getParam(int page){
		String param = "&page="+page; 
		
		return param;
	}

}
