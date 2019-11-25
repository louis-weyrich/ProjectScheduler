package com.sos.project.entity.settings;

import java.util.Set;

import com.sos.project.entity.enumeration.StyleType;

public class Style {
	
	private Long styleId;
	private StyleType type;
	private String name;
	private Set <StyleAttribute> styleAttributes;

	public Style() {
		// TODO Auto-generated constructor stub
	}

	public Long getStyleId()
	{
		return styleId;
	}

	public void setStyleId(Long styleId)
	{
		this.styleId = styleId;
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

	public Set<StyleAttribute> getStyleAttributes() {
		return styleAttributes;
	}

	public void setStyleAttributes(Set<StyleAttribute> styleAttributes) {
		this.styleAttributes = styleAttributes;
	}

}
