package com.test.ok.util.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.test.ok.crwal.vo.CrData;

public class MainAppTodayHumor {

	private static String URL = "http://www.todayhumor.co.kr/board/list.php?table=bestofbest";
/*	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String param = getParam(1);
		System.out.println("가져온 유아엘 " + URL+param);
		
		//1도큐먼트를 가져온다.
		Document doc = docAppend1to10(3);
		
		List<CrData> list = getElement();
		
		System.out.println("사이즈 : " + list.size());
		int i=0;
		//배열에서 정보를 가져온다.
		for (CrData crData : list) {
			System.out.println(crData.toString());
		}
	}
	*/
	

	/**
	 *  
	 * @param param
	 * @return
	 * @throws IOException
	 */
	public static Document docAppend1to10(int param) throws IOException {
		Document doc = Jsoup.connect(URL+getParam(1)).get();
		for (int i = 2; i <= param; i++) {
		  Document doc2 = Jsoup.connect(URL+getParam(i)).get();
		  doc2.appendTo(doc);
		}
		return doc;
	}


	/**
	 * @throws IOException 
	 * 
	 */
	public static List<CrData> getElement(Document doc) throws IOException {
		
		Elements subjects = doc.select(".subject");
		Elements date = doc.select(".date");
		Elements hits = doc.select(".hits");
		Elements ok = doc.select(".oknok");
		Elements name = doc.select(".name");
		Elements no = doc.select(".no");
		
		List<CrData> list = new ArrayList<>();
		for (int i = 0; i < ok.size(); i++) {
			//String subject, String url, String name, String date, String hit, String ok
			CrData crowl = new CrData(subjects.eq(i).text()
								 ,date.eq(i).text()
								 ,name.eq(i).text()
								 ,date.eq(i).text()
								 ,hits.eq(i).text()
								 ,ok.eq(i).text()
								 ,no.eq(i).text()
								 ,"오늘의유머");
			
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
