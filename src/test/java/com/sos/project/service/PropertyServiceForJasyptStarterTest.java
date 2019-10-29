package com.sos.project.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootTest
public class PropertyServiceForJasyptStarterTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Test
	public void whenDecryptedPasswordNeeded_GetFromService() {
	    System.setProperty("jasypt.encryptor.password", "password");
	    PropertyServiceForJasyptStarter service = context
	      .getBean(PropertyServiceForJasyptStarter.class);
	  
	    assertEquals("Password@1", service.getProperty());
	  
	    Environment environment = context.getBean(Environment.class);
	  
	    assertEquals(
	      "Password@1", 
	      service.getPasswordUsingEnvironment(environment));
	}
}
