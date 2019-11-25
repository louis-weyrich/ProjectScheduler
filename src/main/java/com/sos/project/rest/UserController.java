package com.sos.project.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sos.project.dto.security.UserDTO;
import com.sos.project.service.security.UserService;

@RestController
@RequestMapping(path = "rest/user")
public class UserController {
	
	@Value("page.list.batchsize")
	private String batchSize;
	
	@Autowired
	private UserService userService;

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping(path = "/list/active/{page}")
	public List <UserDTO> getActiveUsersList(@PathVariable Integer page)
	{
		int intBatchSize = Integer.valueOf(batchSize);
		return userService.getActiveUsersList(intBatchSize, page);
	}
	

}
