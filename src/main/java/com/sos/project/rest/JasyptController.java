package com.sos.project.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("rest/jasypt")
public class JasyptController 
{
	
	
	
	@GetMapping(value = "/encode/{password}")
	public String encodePassword(@PathVariable("password") String password)
	{
		return "";
	}
}
