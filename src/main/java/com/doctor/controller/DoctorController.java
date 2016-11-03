package com.doctor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.dao.DoctorDaoImpl;
import com.doctor.model.DoctorDetail;

@RestController
public class DoctorController {
	protected final Logger log = LoggerFactory.getLogger(getClass());

	 @Autowired
	    private DoctorDaoImpl doctorDaoImpl;
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String show() {		
		return "test";
	}

	    @RequestMapping("test")
	    public String test() {
	        log.info("Test");
	        return "OK";
	    }

	    @RequestMapping("doctordetails")
	    public DoctorDetail getUser(@RequestParam("id") long id) {
	        log.info("Get user");
	        return doctorDaoImpl.getDoctorDetails(id);
	    }
	

}
