package com.sos.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "project_details", schema = "project_scheduler")
@Entity(name="ProjectDetails")
public class ProjectDetails 
{
	
	@Id
	@Column(name="project_id", nullable = false, updatable = false)
	private Long projectId;
	
	@Column(name="short_desc", length = 256, nullable = true, columnDefinition = "varchar(256)")
	private String shortdescription;
	
	@Column(name="long_desc", nullable = true, columnDefinition = "TEXT")
	private String longDescription;
	
	
	@OneToOne(mappedBy = "details", targetEntity = Project.class)
//	@MapsId
	private Project project;

	
	
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
