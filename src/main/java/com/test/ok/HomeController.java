package com.test.ok;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.ok.crwal.service.CrawlService;
import com.test.ok.crwal.serviceImpl.HumorUniversityServiceImpl;
import com.test.ok.crwal.serviceImpl.todayHumorServiceImpl;
import com.test.ok.crwal.vo.CrData;
import com.test.ok.index.serviceImpl.MyBlogServiceImpl;



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
		crwal = new MyBlogServiceImpl();
		List<CrData> list = crwal.getElement(crwal.docAppend(0));
		System.out.println("받은 값 : " + list.size());
		for (CrData crData : list) {
			System.out.println(crData.toString());
		}
		model.addAttribute("list", list);
		
		return "index.page";
		
		
	}
	  @RequestMapping("/test")
	    public String testPage() {
	        return "test.page";
	    }
	  @RequestMapping("/crwal")
	    public String crwal() {
	        return "home.page";
	    }

	@RequestMapping(value = "/best")
	@ResponseBody
	public List<CrData> best(@RequestParam(value="crwlList[]")List<String> value , HttpServletRequest request ) throws IOException {
		logger.info("Welcome home! The client locale is {}.");
		
		 String page = request.getParameter("page");
			 
		return shuffle( getList(Integer.parseInt(page),value));
	}



	private List<CrData> shuffle(List<CrData> list) {

		Collections.sort(list, new Comparator<CrData>() {
			@Override
			public int compare(CrData o1, CrData o2) {
				// TODO Auto-generated method stub
				if(o1.getNum()> o2.getNum()) return 1;
				else if(o1.getNum()< o2.getNum()) return -1;
				else return 0;
			}
		});
	
		return list;
	}



	/**
	 * @param vo
	 * @throws IOException 
	 */
	private List<CrData> getList(int callPageNum, List<String> crwlList) throws IOException {
		Map<String,CrawlService> map = new HashMap<>();
		map.put("todayHumor", new todayHumorServiceImpl(true) );
		map.put("humorUniv", new HumorUniversityServiceImpl(true) );
		
		List<CrData> list = new ArrayList<>();
		
		for (String callPageName : crwlList) {
			crwal = map.get(callPageName);
			list.addAll(crwal.getElement(crwal.docAppend(callPageNum)));
		}
		return list;
	}
	
	
}
