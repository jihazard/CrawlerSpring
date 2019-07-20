package com.test.ok.crwal.serviceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.test.ok.crwal.service.CrawlService;
import com.test.ok.crwal.vo.CrData;

import dateUtil.DateUtil;

public class LineEngineerServiceImpl implements CrawlService {
	private boolean isOn = true;
	private static String URL = "https://engineering.linecorp.com/ko/blog/";
	private static String linkURL = "";

	public LineEngineerServiceImpl(boolean isOn) {

		this.isOn = isOn;
	}

	/**
	 *
	 * @param param
	 * @return
	 * @throws IOException
	 */
	@Override
	public Document docAppend(int callPageNum) throws IOException {

		Document doc = Jsoup.connect(URL).get();
		for (int i = 2; i <= 3; i++) {
			Document doc2 = Jsoup.connect(URL + getParam(i)).get();
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
	@Override
	public List<CrData> getElement(Document doc) throws IOException {
		Elements subjects = doc.select("#post-list article[id^=post-] .article-inner");
		Elements title = doc.select("#post-list article[id^=post-] .article-inner .entry-title");
		Elements facImg = doc.select("#post-list article[id^=post-] .article-inner img.avatar");
		Elements writer = doc.select("#post-list article[id^=post-] .article-inner h5.author-name");
		Elements writerInfo = doc.select("#post-list article[id^=post-] .article-inner h5.author-name .byline");
		Elements summury = doc.select("#post-list article[id^=post-] .article-inner .entry-summary");
		Elements url = doc.select("#post-list article[id^=post-] .article-inner a.more-link");

		List<CrData> list = new ArrayList<CrData>();
		for (int i = 0; i < subjects.size(); i++) {
			String writeDate = writerInfo.eq(i).text().replace("|", "").trim();
			String[] writerInfox = writer.eq(i).text().trim().split("\\|");
			try {
				
				CrData crowl = CrData.builder().subject(title.eq(i).text()).explain(summury.eq(i).text())
						.writer(writerInfox[0]).img(facImg.eq(i).attr("src")).url(url.eq(i).attr("href")).type("라인")
						.status(DateUtil.checkStatus(writerInfox[1])).date(writerInfox[1]).build();

				;
				list.add(crowl);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public String getParam(int page) {
		String param = "page/" + page + "/";

		return param;
	}
}
