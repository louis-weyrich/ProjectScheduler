package com.sos.project.service.security;

import java.util.List;

import com.sos.project.dto.security.UserDTO;
import com.sos.project.entity.security.AuthenticatedUser;

public interface UserService 
{
	public List<UserDTO> getActiveUsersList(int batchSize, int page);
	public List<UserDTO> getAllUsersList(int batchSize, int page);
	public UserDTO getUserById(Long id);
	public UserDTO getUserByUsername(String username);
	public AuthenticatedUser getRawUserByUsername(String username);
	public void updateUser(UserDTO user);
	public Long createUser(UserDTO user);
	public void deleteUserById(Long id);
}
