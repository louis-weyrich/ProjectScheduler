package com.sos.project.entity;

import com.sos.project.entity.settings.ProjectStyle;

public class ProjectSettings {
	
	private Long projectId;
	private String resourcesFolder;
	private ProjectStyle style;

	public ProjectSettings() {
		// TODO Auto-generated constructor stub
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getResourcesFolder() {
		return resourcesFolder;
	}

	public void setResourcesFolder(String resourcesFolder) {
		this.resourcesFolder = resourcesFolder;
	}

	public ProjectStyle getStyle() {
		return style;
	}

	public void setStyle(ProjectStyle style) {
		this.style = style;
	}

}
