package com.test.ok.util.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.test.ok.crwal.vo.CrData;

public class WoowaAppHumor {

	private static String URL = "http://woowabros.github.io";
	private static String linkURL = "";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String param = getParam(2);


		//1도큐먼트를 가져온다.
		Document doc = docAppend1to10(3);
		List<CrData> list = getElement(doc);
//
		System.out.println("사이즈 : " + list.size());
//		int i=0;
//		//배열에서 정보를 가져온다.
//		for (CrData crData : list) {
//			System.out.println(crData.toString());
//		}
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
		Elements lists = doc.select(".post-meta");
		Elements subjects = doc.select(".list-module h2");
		Elements writer = doc.select(".list-module span");
		Elements writerImg = doc.select(".list-module img");
		Elements subjectExplain = doc.select(".list-module p");
		Elements url = doc.select(".list-module a[href]");
		Elements img = doc.select(".list-module span");
		Elements faceImg = doc.select("img.gravatar");


		List<CrData> list = new ArrayList<CrData>();
		for (int i = 0; i < faceImg.size(); i++) {
			//String subject, String url, String name, String date, String hit, String ok
			System.out.println("subj ects. :" + lists.eq(i).text().trim().split(",")[2]);

			System.out.println("subj ects. :" + subjects.eq(i).text());
			System.out.println("writer :" + writer.eq(i).text().trim().split(",")[2]);
			System.out.println("urlLink :" + subjectExplain.eq(i).text() );
			System.out.println("writer :" + url.eq(i).attr("href"));
			String[] split = url.eq(i).attr("href").split("/");
			System.out.println("year :" + split[2]);
			System.out.println("month  :" + split[3]);
			System.out.println("day :" + split[4]);
			System.out.println("url :" + url.eq(i).attr("href") );
			System.out.println("faceImg :" + faceImg.get(i).attr("src"));
			//String[] split = url.eq(i).attr("href").split("/");
			CrData crowl = CrData.builder().subject( subjects.eq(i).text())
					.explain(subjectExplain.eq(i).text())
					.writer(url.eq(i).attr("href"))
					.img(faceImg.get(i).attr("src"))
					.url( URL + url.eq(i).attr("href"))
					.date(split[2] +"/"+split[3] +"/" + split[4]).build();
					;

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
