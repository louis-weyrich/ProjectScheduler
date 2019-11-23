package com.sos.project.entity.settings;

public class StyleAttribute {
	
	private Long styleAttributeId;
	private Long styleId;
	private StyleElement element;
	private String styleValue;

	public StyleAttribute() {
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

	public StyleElement getElement() {
		return element;
	}

	public void setElement(StyleElement element) {
		this.element = element;
	}

	public String getStyleValue() {
		return styleValue;
	}

	public void setStyleValue(String styleValue) {
		this.styleValue = styleValue;
	}

}
