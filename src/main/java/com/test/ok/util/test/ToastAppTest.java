package com.test.ok.util.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.helper.DataUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.test.ok.crwal.vo.CrData;

public class ToastAppTest {

	private static String URL = "https://meetup.toast.com";
	private static String linkURL = "";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//1도큐먼트를 가져온다.
		Document doc = docAppend1to10(3);
		System.out.println("---종료");
		List<CrData> list = getElement(doc);
//
//		System.out.println("사이즈 : " + list.size());
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
		Document doc = Jsoup.connect(URL+getParam(1)).get();
		//System.out.println(" "+ doc);
		for (int i = 2; i <= 3; i++) {
		  Document doc2 = Jsoup.connect(URL+getParam(i)).get();
		  System.out.println("URL+getParam(i)  => " + URL+getParam(i));
		  doc2.appendTo(doc);
		}
		return doc;
	}


	/**
	 * @throws IOException
	 *
	 */
	/**
	 * @param doc
	 * @return
	 * @throws IOException
	 */
	public static List<CrData> getElement(Document doc) throws IOException {
		Elements subjects = doc.select("#post-list article[id^=post-] .article-inner");
		Elements title = doc.select("#post-list article[id^=post-] .article-inner .entry-title");
		Elements facImg = doc.select("#post-list article[id^=post-] .article-inner img.avatar");
		Elements writer = doc.select("#post-list article[id^=post-] .article-inner h5.author-name");
		Elements writerInfo = doc.select("#post-list article[id^=post-] .article-inner h5.author-name .byline");
		Elements summury = doc.select("#post-list article[id^=post-] .article-inner .entry-summary");
		Elements url = doc.select("#post-list article[id^=post-] .article-inner a.more-link");
		
		List<CrData> list = new ArrayList<CrData>();
		for (int i = 0; i < subjects.size(); i++) {
			//String subject, String url, String name, String date, String hit, String ok
			//System.out.println("---" + subjects.eq(i));
			String writeDate = writerInfo.eq(i).text().replace("|", "").trim();
			String[] writerInfox = writer.eq(i).text().trim().split("\\|");
			
//			System.out.println("title : " + title.eq(i).text());
//			System.out.println("img :" + facImg.eq(i).attr("src"));
//			System.out.println("img :" + writeDate);
//			System.out.println("summury :" + summury.eq(i).text());
//			System.out.println("url :" + url.eq(i).attr("href"));
			//System.out.println("writer : " +writerInfox[0] +"//" + writerInfox[1]  +"//" + writer.eq(i).text().trim());
			//System.out.println("writer :" + writeDate[0] +"/" + writeDate[1] +"/" + writeDate[2]);
			try {
				DataUtil.checkStatus(writerInfox[1]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CrData crowl = CrData.builder()
					.subject(title.eq(i).text())
					.explain(summury.eq(i).text())
					.writer(writerInfox[0])
					.img(facImg.eq(i).attr("src"))
					.url( URL + url.eq(i).attr("href"))
					.type("TOAST")
					.date(writerInfox[1]).build();
					
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
		String param = "/?page="+page+"/";

		return param;
	}


}
