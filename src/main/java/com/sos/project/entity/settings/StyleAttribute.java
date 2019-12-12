package com.sos.project.entity.settings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="style_attribute")
@Entity(name="StyleAttribute")
public class StyleAttribute {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="style_attribute_id", nullable = false, updatable = false, columnDefinition = "INT")
	private Long styleAttributeId;
	
	@Column(name="style_id", nullable = false, updatable = false, columnDefinition = "INT")
	private Long styleId;
	
	@ManyToOne(targetEntity = StyleElement.class,fetch = FetchType.EAGER)
	private StyleElement element;
	
	@Column(name="style_value", length = 32, columnDefinition = "VARCHAR(32)")
	private String styleValue;
	
	


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
