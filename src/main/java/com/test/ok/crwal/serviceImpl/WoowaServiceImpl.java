package com.test.ok.crwal.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.test.ok.crwal.service.CrawlService;
import com.test.ok.crwal.vo.CrData;

public class WoowaServiceImpl implements CrawlService {
	private boolean isOn = true;
	private static String URL = "http://woowabros.github.io";
	private static String linkURL = "";


	public WoowaServiceImpl(boolean isOn) {

		this.isOn = isOn;
	}

	@Override
	public Document docAppend(int callPageNum) throws IOException {
		Document doc = Jsoup.connect(URL).get();
	/*	for (int i = 2; i <= callPageNum; i++) {
		  Document doc2 = Jsoup.connect(URL+getParam(i)).get();
		  doc2.appendTo(doc);
		}*/
		return doc;
	}

	@Override
	public List<CrData> getElement(Document doc) throws IOException {
		Elements lists = doc.select(".list-module");
		Elements subjects = doc.select(".list-module h2");
		Elements writer = doc.select(".post-meta");
		Elements writerImg = doc.select(".list-module img");
		Elements subjectExplain = doc.select(".list-module p");
		Elements url = doc.select(".list-module a[href]");
		Elements img = doc.select(".list-module span");
		Elements faceImg = doc.select("img.gravatar");

		List<CrData> list = new ArrayList<CrData>();
		if(isOn){
			for (int i = 0; i < faceImg.size(); i++) {
				String[] split = url.eq(i).attr("href").split("/");

				CrData crowl = CrData.builder()
						.subject(subjects.eq(i).text())
						.explain(subjectExplain.eq(i).text())
						.writer(writer.eq(i).text().trim().split(",")[2])
						.img(faceImg.get(i).attr("src"))
						.url( URL + url.eq(i).attr("href"))
						.date(split[2] +"/"+split[3] +"/" + split[4]).build();
						;

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
