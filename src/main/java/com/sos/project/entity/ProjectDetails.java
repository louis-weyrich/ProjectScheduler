package com.sos.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "project_details", schema = "project_scheduler")
@Entity(name="Projectdetails")
public class ProjectDetails {
	
	@Id
	@Column(name="project_id", nullable = false, updatable = false)
	private Long projectId;
	
	@Column(name="short_desc", length = 256, nullable = true, columnDefinition = "varchar(256)")
	private String shortdescription;
	
	@Column(name="long_desc", nullable = true, columnDefinition = "TEXT")
	private String longDescription;


}
