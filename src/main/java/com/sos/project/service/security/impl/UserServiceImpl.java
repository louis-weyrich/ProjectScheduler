package com.sos.project.service.security.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sos.project.dto.UserDTO;
import com.sos.project.entity.security.AuthenticatedUser;
import com.sos.project.exception.UserException;
import com.sos.project.repository.security.UserRepository;
import com.sos.project.service.security.UserService;


@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * 
	 * @param batchSize
	 * @param page
	 * @return
	 */
	public List<UserDTO> getUsersList(int batchSize, int page)
	{
		Page <AuthenticatedUser> userList = userRepo.findAllActiveUsers(PageRequest.of(page, batchSize));
		List <UserDTO> dtoList = new ArrayList <UserDTO> (userList.getSize());
		
		for(AuthenticatedUser user : userList)
		{
			dtoList.add(new UserDTO(user));
		}
		
		return dtoList;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public UserDTO getUserById(Long id)
	{
		Optional<AuthenticatedUser> userOption = userRepo.findById(id);
		if(userOption.isPresent())
		{
			return new UserDTO(userOption.get());
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public UserDTO getUserByUsername(String username)
	{
		AuthenticatedUser user = userRepo.getUserByUsername(username);
		
		if(user != null)
		{
			return new UserDTO(user);
		}
		else
		{
			return null;
		}
	}
	
	public AuthenticatedUser getRawUserByUsername(String username)
	{
		AuthenticatedUser user = userRepo.getUserByUsername(username);
		
		if(user != null)
		{
			return user;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * 
	 * @param user
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public void updateUser(UserDTO user)
	{
		if(user.getPassword() != null && !user.getPassword().isEmpty())
		{
			String password = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPasswordHash(password);
		}
		else
		{
			AuthenticatedUser aUser = userRepo.getUserByUsername(user.getUsername());
			user.setPasswordHash(aUser.getPasswordHash());
		}
		
		userRepo.saveAndFlush(new AuthenticatedUser(user));
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = {Exception.class})
	public Long createUser(UserDTO user)
	{
		if(user.getPassword() != null && !user.getPassword().isEmpty())
		{
			String password = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPasswordHash(password);
		}
		else
		{
			throw new UserException(user, "Unable to create user: (empty password)");
		}
		
		return userRepo.saveAndFlush(new AuthenticatedUser(user)).getUserId();
	}
	
	/**
	 * 
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = {Exception.class})
	public void deleteUserById(Long id)
	{
		userRepo.deleteById(id);
	}
	
}
