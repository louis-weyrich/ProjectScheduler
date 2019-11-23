package com.sos.project.entity.settings;

public class ProjectSettings {
	
	private Long projectId;
	private String resourcesFolder;
	private Theme style;

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

	public Theme getStyle() {
		return style;
	}

	public void setStyle(Theme style) {
		this.style = style;
	}

}
