package com.test.ok;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.ok.service.CrawlService;
import com.test.ok.serviceImpl.HumorUniversityServiceImpl;
import com.test.ok.serviceImpl.todayHumorServiceImpl;
import com.test.ok.util.CrData;
import com.test.ok.util.CrVO;
import com.test.ok.util.MainAppTodayHumor;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private CrawlService crwal;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws IOException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
		
		
	}
	
	

	@RequestMapping(value = "/best")
	@ResponseBody
	public List<CrData> best(@ModelAttribute CrVO vo ) throws IOException {
		logger.info("Welcome home! The client locale is {}.");
		List<CrData> list = new ArrayList<>();
		list = getList(list);

		Collections.shuffle(list);    
		return list;
	}



	/**
	 * @param vo
	 * @throws IOException 
	 */
	private List<CrData> getList(List<CrData> list) throws IOException {
		Map<String,CrawlService> map = new HashMap<>();
		map.put("오늘의유머", new todayHumorServiceImpl(true) );
		map.put("웃대", new HumorUniversityServiceImpl(true) );
		
		//구현전 테스트를 위해 만든 부분
		List<String> list2 = new ArrayList<>();
		list2.add("오늘의유머");
		list2.add("웃대");
		
		for (String string : list2) {
			crwal = map.get(string);
			list.addAll(crwal.getElement(crwal.docAppend(2)));
		}
		return list;
	}
}
