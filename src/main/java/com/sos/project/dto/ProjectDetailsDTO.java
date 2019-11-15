package com.sos.project.dto;

import com.sos.project.entity.Project;
import com.sos.project.entity.ProjectDetails;

public class ProjectDetailsDTO
{
	
	private Long projectId;
	private String shortdescription;
	private String longDescription;
	private Project project;


	public ProjectDetailsDTO()
	{
		// Do nothing
	}


	public ProjectDetailsDTO(ProjectDetails details)
	{
		if(details != null)
		{
    		this.projectId = details.getProjectId();
    		this.longDescription = details.getLongDescription();
    		this.shortdescription = details.getShortdescription();
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


	public String getShortdescription()
	{
		return shortdescription;
	}


	public void setShortdescription(String shortdescription)
	{
		this.shortdescription = shortdescription;
	}


	public String getLongDescription()
	{
		return longDescription;
	}


	public void setLongDescription(String longDescription)
	{
		this.longDescription = longDescription;
	}


	public Project getProject()
	{
		return project;
	}


	public void setProject(Project project)
	{
		this.project = project;
	}

}
