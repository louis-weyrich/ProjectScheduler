package com.sos.project.dto.settings;

public class StyleAttributeDTO {
	
	private Long styleAttributeId;
	private Long styleId;
	private StyleElementDTO element;
	private Object styleValue;

	public StyleAttributeDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getStyleAttributeId() {
		return styleAttributeId;
	}

	public void setStyleAttributeId(Long styleAttributeId) {
		this.styleAttributeId = styleAttributeId;
	}

	public Long getStyleId() {
		return styleId;
	}

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	public StyleElementDTO getElement() {
		return element;
	}

	public void setElement(StyleElementDTO element) {
		this.element = element;
	}

	public Object getStyleValue() {
		return styleValue;
	}

	public void setStyleValue(Object styleValue) {
		this.styleValue = styleValue;
	}

}
