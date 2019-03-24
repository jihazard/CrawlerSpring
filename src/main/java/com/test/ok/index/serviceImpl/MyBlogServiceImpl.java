package com.test.ok.index.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.test.ok.crwal.service.CrawlService;
import com.test.ok.crwal.vo.CrData;

public class MyBlogServiceImpl implements CrawlService{
	private static String URL = "https://jihazarrd.tistory.com/";
	@Override
	public Document docAppend(int callPageNum) throws IOException {
		Document doc = Jsoup.connect(URL).get();
		return doc;
	}

	@Override
	public List<CrData> getElement(Document doc) throws IOException {
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

	@Override
	public String getParam(int page) {
		// TODO Auto-generated method stub
		return null;
	}

}
