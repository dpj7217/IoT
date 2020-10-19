package main.com.Controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.com.Business.MakeChirp;


@Controller
@Component
@RequestMapping("/Chirp")
public class ChirpController {

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public void AddFiveChrips() {
        MakeChirp mc = new MakeChirp();

	    for (int i = 1; i <= 5; i++) {
	       mc.MakeRandomChirp();
	       System.out.println("Making Chirp" + i);
	    } 
	
	}
}
