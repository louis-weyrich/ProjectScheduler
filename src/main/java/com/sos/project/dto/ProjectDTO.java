package com.sos.project.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sos.project.entity.Project;
import com.sos.project.entity.enumeration.Status;

public class ProjectDTO
{

	private Long projectId;
	private String projectName;
	private List<ProjectDTO> subProject;
	private Status 	status = Status.OPEN;
	private Date dateCreated;
	private Date dateClosed;
	private ProjectDetailsDTO details;

	
	
	public ProjectDTO()
	{
		// Do Nothing
	}
	
	
	public ProjectDTO(Project project)
	{
		if(project != null)
		{
    		this.projectId = project.getProjectId();
    		this.projectName = project.getProjectName();
    		this.dateCreated = project.getDateCreated();
    		this.dateClosed = project.getDateClosed();
    		this.status = project.getStatus();
    		this.details = new ProjectDetailsDTO((project.getDetails() != null)?project.getDetails() : null);
    		
    		this.subProject = new ArrayList<ProjectDTO> (project.getSubProjects().size());
    		
    		for(Project subProject : project.getSubProjects())
    		{
    			this.subProject.add(new ProjectDTO(subProject));
    		}
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


	public List<ProjectDTO> getSubProject()
	{
		return subProject;
	}


	public void setSubProject(List<ProjectDTO> subProject)
	{
		this.subProject = subProject;
	}

}
