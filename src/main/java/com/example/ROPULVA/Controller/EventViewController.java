package com.example.ROPULVA.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class EventViewController {
	 @GetMapping("/Events")
	    public String showJobsPage() {
	        return "Events";
	    }

}
