package com.doctor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String show() {		
		return "test";
	}

}
