package com.sos.project.dto.settings;

public class ProjectSettingsDTO {
	
	private Long projectId;
	private String resourcesFolder;
	private ThemeDTO style;

	public ProjectSettingsDTO() {
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

	public ThemeDTO getStyle() {
		return style;
	}

	public void setStyle(ThemeDTO style) {
		this.style = style;
	}

}
