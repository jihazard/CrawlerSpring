package com.test.ok;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.ok.util.CrData;
import com.test.ok.util.MainAppTodayHumor;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws IOException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		
		Document doc = MainAppTodayHumor.docAppend1to10(3);
		List<CrData> list = MainAppTodayHumor.getElement(doc);
		
		model.addAttribute("data", list);
		
		
		return "home";
	}
	
	

	@RequestMapping(value = "/best", method = RequestMethod.POST)
	@ResponseBody
	public List<CrData> best(Locale locale, Model model) throws IOException {
		logger.info("Welcome home! The client locale is {}.", locale);
	
		
		Document doc = MainAppTodayHumor.docAppend1to10(3);
		List<CrData> list = MainAppTodayHumor.getElement(doc);

		return list;
	}
}
