package com.sos.project.rest;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sos.project.entity.security.AuthenticatedUser;
import com.sos.project.service.security.impl.UserServiceImpl;

//import com.sos.supflow.entity.UserContact;
//import com.sos.supflow.service.UserContactService;

@RestController
@RequestMapping("rest/password")
public class PasswordController
{
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserServiceImpl userService;
	

	@GetMapping(value = "/encrypt/{mypassword}", produces = "application/json")
	public String encryptPassword(@PathVariable("mypassword") String password)
	{
		String pword =  bCryptPasswordEncoder.encode(password);
		return pword;
	}

	
	@GetMapping(value = "/decrypt/{password}/{hash}", produces = "application/json")
	public Boolean decryptPassword(@PathVariable("hash") String hash, @PathParam("password") String password)
	{
		return bCryptPasswordEncoder.matches(password, hash);
	}
	
	@GetMapping(value = "/can-login/{username}/{password}", produces = "application/json")
	public Boolean canLogin(@PathVariable("username") String username,  @PathVariable("password") String password)
	{
//		AuthenticatedUser user = userService.getRawUserByUsername(username);
//		if(user != null)
//		{
//			return bCryptPasswordEncoder.matches(password, user.getPasswordHash());
//		}
		
		return false;
	}
}
