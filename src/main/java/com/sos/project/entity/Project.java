package com.sos.project.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.sos.project.entity.enumeration.Status;
import com.sos.project.entity.enumeration.StatusConverter;


@Table(name = "projects", schema = "project_scheduler")
@Entity(name="Projects")
public class Project 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id", nullable = false, updatable = false)
	private Long projectId;
	
	@Column(name="project_name", length = 48, nullable = false, updatable = false, unique = true, columnDefinition = "varchar(48)")
	private String projectName;

	@Convert(converter=StatusConverter.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status 	status = Status.OPEN;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created", nullable = true, columnDefinition = "TIMESTAMP")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date dateCreated;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_closed", nullable = true, columnDefinition = "TIMESTAMP")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date dateClosed;
	
	@OneToOne(targetEntity = ProjectDetails.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private ProjectDetails details;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Project.class)
	@JoinTable(name = "sub_projects",  joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "project_id"), inverseJoinColumns = @JoinColumn(name = "sub_project_id"))
	private Set<Project> subProjects;
	

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}

	public ProjectDetails getDetails() {
		return details;
	}

	public void setDetails(ProjectDetails details) {
		this.details = details;
	}

	public Set<Project> getSubProjects()
	{
		return subProjects;
	}

	public void setSubProjects(Set<Project> subProjects)
	{
		this.subProjects = subProjects;
	}
	
}
