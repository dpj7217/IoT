package main.com.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import main.com.Business.AudioBusinessInterface;
import main.com.Models.Audio;
import com.google.gson.Gson;
@Controller 
@RequestMapping("/home")
public class HomeController {
		//SpringBean declaration
		AudioBusinessInterface service;
		/**
		 * Method to set the bean
		 * @param interface that the methods will refer to 
		 */
		public void setUserService(AudioBusinessInterface service) {
		this.service = service;
		}
	
		@RequestMapping(path="/home", method=RequestMethod.GET)
		public ModelAndView displayHomePage() { 
			return new ModelAndView("homePage");
		}
		@RequestMapping(path="/AudioOverTime", method=RequestMethod.GET)
		public ModelAndView displayAudioOverTime() { 
			//Get all audio form dataservice
			try {
				List<Audio> audios =service.getAudio();	
				Gson gson = new Gson();
				Map<Object,Object> map = null;
				List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
				for(int i=0; i<audios.size();i++) {
					map = new HashMap<Object,Object>(); map.put("x", i);  map.put("y", audios.get(i).getDba());list.add(map);
				}
				
				String audio = gson.toJson(list);
				return new ModelAndView("AudioOverTime", "audio", audio); 
			} catch (Exception e) {
				//create a ModelAndView 
				ModelAndView mv = new ModelAndView("errorPage"); 
						
				//create a string message for the errorPage 
				String err = "ERROR: " + e.getMessage();
						
				//create new object to output the error
				mv.addObject("error", err); 
						
				//return to create event form page to show the connection error
				return mv; 
			}
		}
		@RequestMapping(path="/ChirpsOverTime", method=RequestMethod.GET)
		public ModelAndView displayChirpsOverTime() { 
			//Get all chirps form dataservice
			try {
				ArrayList<Audio> audios =service.getAudio();
				ArrayList<Audio> chirps =service.getChirps();
				ArrayList<String> aList = new ArrayList<String>(2); 
				Gson gson = new Gson();
				Map<Object,Object> map = null;
				List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();				 
				
				for(int i=0; i<audios.size();i++) {
					map = new HashMap<Object,Object>(); map.put("x", audios.get(i).getTimestamp()); map.put("y", audios.get(i).getDba()); list.add(map);
				}
				String audio = gson.toJson(list);
				aList.add(1,audio);
				list = new ArrayList<Map<Object,Object>>();
				for(int i=0; i<chirps.size();i++) {
					map = new HashMap<Object,Object>(); map.put("x", chirps.get(i).getTimestamp()); map.put("y", chirps.get(i).getDba()); list.add(map);
				}
				audio = gson.toJson(list);
				aList.add(2,audio);	
				
				return new ModelAndView("ChirpsOverTime", "data", aList); 
				
			} catch (Exception e) {
				//create a ModelAndView 
				ModelAndView mv = new ModelAndView("errorPage"); 
						
				//create a string message for the errorPage 
				String err = "ERROR: " + e.getMessage();
						
				//create new object to output the error
				mv.addObject("error", err); 
						
				//return to create event form page to show the connection error
				return mv; 
			}
		}


}
