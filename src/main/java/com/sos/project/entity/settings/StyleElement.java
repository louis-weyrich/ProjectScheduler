package com.sos.project.entity.settings;

public class StyleElement {
	
	private Long elementId;
	private String name;
	private boolean active;

	public StyleElement() {
		// TODO Auto-generated constructor stub
	}

	public Long getElementId() {
		return elementId;
	}

	public void setElementId(Long elementId) {
		this.elementId = elementId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
