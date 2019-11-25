package com.sos.project.entity.settings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "project_settings", schema = "project_scheduler")
@Entity(name="ProjectSettings")
public class ProjectSettings {
	
	@Id
	@Column(name="project_id", nullable = false, updatable = false)
	private Long projectId;
	
	@ManyToOne(targetEntity = Theme.class, optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "theme_id",referencedColumnName = "theme_id")
	private Theme theme;

	
	
	public ProjectSettings() {
		// TODO Auto-generated constructor stub
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}
