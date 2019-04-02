package com.test.ok.crwal.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.test.ok.crwal.service.CrawlService;
import com.test.ok.crwal.vo.CrData;

public class todayHumorServiceImpl implements CrawlService {
	private boolean isOn = true;
	private static String URL = "http://www.todayhumor.co.kr/board/list.php?table=bestofbest";
	private static String linkURL = "http://www.todayhumor.co.kr/board/view.php?table=bestofbest&no=";
	
	
	public todayHumorServiceImpl(boolean isOn) {

		this.isOn = isOn;
	}

	@Override
	public Document docAppend(int callPageNum) throws IOException {
		Document doc = Jsoup.connect(getParam(callPageNum)).get();
	/*	for (int i = 2; i <= callPageNum; i++) {
		  Document doc2 = Jsoup.connect(URL+getParam(i)).get();
		  doc2.appendTo(doc);
		}*/
		return doc;
	}

	@Override
	public List<CrData> getElement(Document doc) throws IOException {
		Elements subjects = doc.select(".subject");
		Elements date = doc.select(".date");
		Elements hits = doc.select(".hits");
		Elements ok = doc.select(".oknok");
		Elements name = doc.select(".name");
		Elements no = doc.select(".no");
		
		List<CrData> list = new ArrayList<CrData>();
		if(isOn){
			for (int i = 0; i < ok.size(); i++) {
				CrData crowl = new CrData(subjects.eq(i).text()
									 ,linkURL + no.eq(i).text()
									 ,name.eq(i).text()
									 ,date.eq(i).text().replace("19/", "")
									 ,hits.eq(i).text()
									 ,ok.eq(i).text()
									 ,no.eq(i).text(),"오유",i);
				
				list.add(crowl);
				
			}
		}
		
		return list;
	}

	@Override
	public String getParam(int page) {
		String param = URL+"&page="+page; 
		return param;
	}
	
	
	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
	
	

}
