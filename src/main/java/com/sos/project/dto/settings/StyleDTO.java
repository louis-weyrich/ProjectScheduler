package com.sos.project.dto.settings;

import java.util.Set;

import com.sos.project.entity.enumeration.StyleType;

public class StyleDTO {
	
	private StyleType type;
	private String name;
	private Set <StyleAttributeDTO> styleAttributeDTOs;

	public StyleDTO() {
		// TODO Auto-generated constructor stub
	}

	public StyleType getType() {
		return type;
	}

	public void setType(StyleType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<StyleAttributeDTO> getStyleAttributes() {
		return styleAttributeDTOs;
	}

	public void setStyleAttributes(Set<StyleAttributeDTO> styleAttributeDTOs) {
		this.styleAttributeDTOs = styleAttributeDTOs;
	}

}
