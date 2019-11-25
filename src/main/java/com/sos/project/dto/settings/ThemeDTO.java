package com.sos.project.dto.settings;

import java.util.Set;

public class ThemeDTO {
	
	private Long settingId;
	private String name;
	private Set <StyleDTO> styleDTOs;

	public ThemeDTO() {
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

	public Set<StyleDTO> getStyles() {
		return styleDTOs;
	}

	public void setStyles(Set<StyleDTO> styleDTOs) {
		this.styleDTOs = styleDTOs;
	}

}
