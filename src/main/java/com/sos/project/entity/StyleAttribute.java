package com.sos.project.entity;

public class StyleAttribute {
	
	private Long styleAttributeId;
	private Long styleId;
	private String styleName;
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

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public String getStyleValue() {
		return styleValue;
	}

	public void setStyleValue(String styleValue) {
		this.styleValue = styleValue;
	}

}
