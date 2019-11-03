package com.sos.project.config;

import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;

@Configuration
@EncryptablePropertySource(name = "EncryptedProperties", value = "classpath:encrypted.properties")
public class AppConfigForJasyptStarter {
	
	
}
