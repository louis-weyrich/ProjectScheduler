package com.sos.project.dto.security;

public class LoginUserDTO
{
	
	private String username;
	private String password;

	
	public LoginUserDTO()
	{
		// Do Nothing
	}
	
	
	public LoginUserDTO(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUserName(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
