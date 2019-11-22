package com.sos.project.entity;

import java.util.Set;

public class ProjectStyle {
	
	private Long settingId;
	private String name;
	private Set <Style> styles;

	public ProjectStyle() {
		// TODO Auto-generated constructor stub
	}

	public Long getSettingId() {
		return settingId;
	}

	public void setSettingId(Long settingId) {
		this.settingId = settingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Style> getStyles() {
		return styles;
	}

	public void setStyles(Set<Style> styles) {
		this.styles = styles;
	}

}
