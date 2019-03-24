package com.test.ok.crwal.service;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;

import com.test.ok.crwal.vo.CrData;

public interface CrawlService {
	
	public Document docAppend(int callPageNum)  throws IOException;
	public List<CrData>getElement(Document doc)  throws IOException; 
	public String getParam(int page);
}
