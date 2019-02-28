package com.pilot.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class PilotController {

	static {
		System.out.println("Controller loaded..");
	}
	@RequestMapping ("/hi")
	public void testController(){
		System.out.println("hi is called...");
	}
	
	
	
	
	
}
