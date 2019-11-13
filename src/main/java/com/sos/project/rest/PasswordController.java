package com.sos.project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sos.project.dto.UserDTO;
import com.sos.project.entity.security.AuthenticatedUser;
import com.sos.project.exception.UserException;
import com.sos.project.service.security.impl.UserServiceImpl;


@RestController
@RequestMapping("rest/public/password")
public class PasswordController
{
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserServiceImpl userService;
	

	@RequestMapping(value = "/encrypt/{mypassword}", method = RequestMethod.GET, produces = "application/json")
	public String encryptPassword(@PathVariable("mypassword") String password)
	{
		return bCryptPasswordEncoder.encode(password);
	}

	
	@RequestMapping(value = "/decrypt/{password}/{hash}", method = RequestMethod.GET, produces = "application/json")
	public Boolean decryptPassword(@PathVariable("hash") String hash, @PathVariable("password") String password)
	{
		return bCryptPasswordEncoder.matches(password, hash);
	}
	
	@RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET, produces = "application/json")
	public UserDTO canLogin(@PathVariable("username") String username,  @PathVariable("password") String password)
	{
		AuthenticatedUser user = userService.getRawUserByUsername(username);
		if(user != null)
		{
			if(bCryptPasswordEncoder.matches(password, user.getPasswordHash()))
			{
				return new UserDTO(user);
			}
			else
			{
				throw new UserException("Password did not match for user "+username);
			}
		}
		
		throw new UserException("User "+username+" was not found");
	}
}
