package com.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class HomeController {
		@RequestMapping(path="/home", method=RequestMethod.GET)
		public ModelAndView displayHomePage() { 
			return new ModelAndView("homePage");
		}

}
