package com.sos.project.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.sos.project.entity.Project;
import com.sos.project.entity.security.AuthenticatedUser;
import com.sos.project.entity.security.Permission;
import com.sos.project.entity.security.Role;

public class UserDTO 
{
 
	private Long userId;
	
	@Size(min = 8, max = 48, message = "Username must be greater than 7 and less than 49")
	private String username;
	
	@NotEmpty
	private String fullName;
	
	private String passwordHash;
	
	private String password;
	
	@Email
	private String email;
	
	private String phone;
	
	private Boolean status;
	
	@Past
	private Date dateActive;
	
	private Date dateDeactivated;
	
    private Set<PermissionDTO> permissions;
    
    private Set<ProjectDTO> projects;
    
    public UserDTO() {
    	
    }
    
    public UserDTO(AuthenticatedUser user) 
    {
    	this.userId = user.getUserId();
    	this.username = user.getUsername();
    	this.fullName = user.getFullName();
//    	this.passwordHash = user.getPasswordHash();
    	this.email = user.getEmail();
    	this.phone = user.getPhone();
    	this.status = user.getStatus();
    	this.dateActive = user.getDateActive();
    	this.dateDeactivated = user.getDateDeactivated();
    	
    	if(user.getRoles() != null)
    	{
    		this.permissions = new HashSet<PermissionDTO> ();
    		
    		for(Role role : user.getRoles())
    		{
    			if(role.getPermissions() != null)
    			{
    				for(Permission permission : role.getPermissions())
    				{
    					permissions.add(new PermissionDTO(permission.getPermissionId(), permission.getPermissionName(), permission.getRoleType()));
    				}
    			}
    		}
    		
    		this.projects = new HashSet<ProjectDTO> ();
    		
    		for(Project project : user.getProjects())
    		{
    			if(project != null)
    				projects.add(new ProjectDTO(project));
    		}
    	}
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getDateActive() {
		return dateActive;
	}

	public void setDateActive(Date dateActive) {
		this.dateActive = dateActive;
	}

	public Date getDateDeactivated() {
		return dateDeactivated;
	}

	public void setDateDeactivated(Date dateDeactivated) {
		this.dateDeactivated = dateDeactivated;
	}

	public Set<PermissionDTO> getPermissions() 
	{
		if(permissions == null)
		{
			this.permissions = new HashSet <PermissionDTO> ();
		}
		
		return permissions;
	}

	public void setPermissions(Set<PermissionDTO> permissions) {
		this.permissions = permissions;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<ProjectDTO> getProjects()
	{
		return projects;
	}

	public void setProjects(Set<ProjectDTO> projects)
	{
		this.projects = projects;
	}

}
