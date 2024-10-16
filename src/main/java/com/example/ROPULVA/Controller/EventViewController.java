package com.example.ROPULVA.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

//http://localhost:8089/Events
public class EventViewController {
	 @GetMapping("/Events")
	    public String showJobsPage() {
	        return "Events";
	    }

}
