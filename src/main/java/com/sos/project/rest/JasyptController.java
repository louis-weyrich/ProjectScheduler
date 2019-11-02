package com.sos.project.rest;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("rest/jasypt")
public class JasyptController 
{
	
	@Autowired(required = true)
	private StringEncryptor encryptor;
	
	
	@GetMapping(value = "/encode/{password}")
	public String encodePassword(@PathVariable("password") String password)
	{
		return encryptor.encrypt(password);
	}
	
	@GetMapping(value = "/decode/{password}")
	public String decodePassword(@PathVariable("password") String password)
	{
		return encryptor.decrypt(password);
	}
}
