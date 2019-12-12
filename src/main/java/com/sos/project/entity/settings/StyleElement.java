package com.sos.project.entity.settings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="style_element")
@Entity(name="StyleElement")
public class StyleElement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="style_element_id", nullable = false, updatable = false, columnDefinition = "INT")
	private Long elementId;
	
	@Column(name="name", nullable = false, updatable = false, columnDefinition = "VARCHAR(32)")
	private String name;
	
	@Column(name="active", nullable = false, updatable = true, columnDefinition = "TINYINT DEFAULT 1")
	private boolean active;
	
	


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
