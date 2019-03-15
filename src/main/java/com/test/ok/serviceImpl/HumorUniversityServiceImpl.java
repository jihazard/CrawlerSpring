package com.test.ok.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.test.ok.service.CrawlService;
import com.test.ok.util.CrData;

public class HumorUniversityServiceImpl implements CrawlService {
	private boolean isOn = true;
	private static String URL = "http://web.humoruniv.com/board/humor/list.html?table=pds&st=day&";
	private static String linkURL = "http://web.humoruniv.com/board/humor/read.html?table=pds&st=day&pg=0&number=";
	
	public HumorUniversityServiceImpl(boolean isOn) {

		this.isOn = isOn;
	}

	@Override
	public Document docAppend(int callPageNum) throws IOException {
		Document doc = Jsoup.connect(URL+getParam(1)).get();
		for (int i = 2; i <= callPageNum; i++) {
		  Document doc2 = Jsoup.connect(URL+getParam(i)).get();
		  doc2.appendTo(doc);
		}
		return doc;
	}

	@Override
	public List<CrData> getElement(Document doc) throws IOException {
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


	@Override
	public String getParam(int page) {
		String param = "pg="+page; 
		return param;
	}
	
	
	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
	
	

}
