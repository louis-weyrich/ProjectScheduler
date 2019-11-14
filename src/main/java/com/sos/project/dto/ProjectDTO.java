package com.sos.project.dto;

import java.util.Date;
import java.util.Set;

import com.sos.project.entity.Project;
import com.sos.project.entity.ProjectDetails;
import com.sos.project.entity.enumeration.Status;
import com.sos.project.entity.security.AuthenticatedUser;

public class ProjectDTO
{

	private Long projectId;
	private String projectName;
	private ProjectDTO parentProject;
	private Status 	status = Status.OPEN;
	private Date dateCreated;
	private Date dateClosed;
	private ProjectDetailsDTO details;
	private Set<AuthenticatedUser> users;

	
	
	public ProjectDTO()
	{
		// TODO Auto-generated constructor stub
	}
	
	
	public ProjectDTO(Project project)
	{
		if(project != null)
		{
    		this.projectId = project.getProjectId();
    		this.projectName = project.getProjectName();
    		this.parentProject = new ProjectDTO((project.getParentProject() != null)?project.getParentProject() : null);
    		this.dateCreated = project.getDateCreated();
    		this.dateClosed = project.getDateClosed();
    		this.status = project.getStatus();
    		this.details = new ProjectDetailsDTO((project.getDetails() != null)?project.getDetails() : null);
		}
	}



	public Long getProjectId()
	{
		return projectId;
	}



	public void setProjectId(Long projectId)
	{
		this.projectId = projectId;
	}



	public String getProjectName()
	{
		return projectName;
	}



	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}



	public ProjectDTO getParentProject()
	{
		return parentProject;
	}



	public void setParentProject(ProjectDTO parentProject)
	{
		this.parentProject = parentProject;
	}



	public Status getStatus()
	{
		return status;
	}



	public void setStatus(Status status)
	{
		this.status = status;
	}



	public Date getDateCreated()
	{
		return dateCreated;
	}



	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}



	public Date getDateClosed()
	{
		return dateClosed;
	}



	public void setDateClosed(Date dateClosed)
	{
		this.dateClosed = dateClosed;
	}



	public ProjectDetailsDTO getDetails()
	{
		return details;
	}



	public void setDetails(ProjectDetailsDTO details)
	{
		this.details = details;
	}



	public Set<AuthenticatedUser> getUsers()
	{
		return users;
	}



	public void setUsers(Set<AuthenticatedUser> users)
	{
		this.users = users;
	}

}
