package com.app.backend;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping("/test")
	@ResponseBody
	public HashMap<String, String> test(){
		HashMap<String, String> ob = new HashMap<String, String>();
		ob.put("StudentName", "Vicky");
		ob.put("StudentClass", "X");
		ob.put("StudentRollNo", "10");

		System.out.println("this is testing");
		return ob;
	}

}
