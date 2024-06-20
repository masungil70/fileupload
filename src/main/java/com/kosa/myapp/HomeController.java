package com.kosa.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="uploadFile", method = RequestMethod.POST) 
	public Map<String, Object> uploadFile(UploadDTO uploadDTD) {
		Map<String, Object> result = new HashMap();
		result.put("status", false);
		
		System.out.println("id = " + uploadDTD.getId());
		System.out.println("name = " + uploadDTD.getName());
		if (uploadDTD.getFile() != null) {
			for (MultipartFile file : uploadDTD.getFile()) { 
				System.out.println("contentType = " + file.getContentType());
				System.out.println("size = " + file.getSize());
				System.out.println("name = " + file.getName());
				System.out.println("originalFilename = " + file.getOriginalFilename());
				
				//해당 위치에서 첨부 파일을 저장하면됨 
			}
		}
		result.put("status", true);
		return result;
	}
	
}
