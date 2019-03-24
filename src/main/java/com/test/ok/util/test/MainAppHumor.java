package com.test.ok.util.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.test.ok.crwal.vo.CrData;

public class MainAppHumor {

	private static String URL = "http://web.humoruniv.com/board/humor/list.html?table=pds&st=day&";
	private static String linkURL = "http://web.humoruniv.com/board/humor/read.html?table=pds&st=day&pg=0&number=";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String param = getParam(2);
		System.out.println("가져온 유아엘 " + URL+param);
		
		//1도큐먼트를 가져온다.
		Document doc = docAppend1to10(3);
		System.out.println(" " + doc.toString());
		List<CrData> list = getElement(doc);
		
		System.out.println("사이즈 : " + list.size());
		int i=0;
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
		Document doc = Jsoup.connect(URL+getParam(1)).get();
		//System.out.println(" "+ doc);
		for (int i = 2; i <= 3; i++) {
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
		Elements no = doc.select("tr[id^=li_chk_pds-]");
		Elements subjects = doc.select(".li_sbj");
		Elements date = doc.select(".li_date");
		Elements hits = doc.select(".li_und");
		Elements ok = doc.select(".o");
		Elements name = doc.select(".hu_nick_txt");
		
		
		List<CrData> list = new ArrayList<>();
		for (int i = 0; i < ok.size(); i++) {
			//String subject, String url, String name, String date, String hit, String ok
			CrData crowl = new CrData(subjects.eq(i).text()
								 ,linkURL + no.eq(i).attr("id").replace("li_chk_pds-", "")
								 ,name.eq(i).text()
								 ,date.eq(i).text()
								 ,hits.eq(i).text()
								 ,ok.eq(i).text()
								 ,no.eq(i).attr("id").replace("li_chk_pds-", "")
								 ,"웃대");
			
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
		String param = "pg="+page; 
		
		return param;
	}

}
