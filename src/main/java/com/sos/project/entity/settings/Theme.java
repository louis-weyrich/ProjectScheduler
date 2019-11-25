package com.sos.project.entity.settings;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Theme 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="theme_id", nullable = false, updatable = false, columnDefinition = "INT")
	private Long themeId;
	
	@Column(name="name", insertable = true, updatable = false, length = 26, columnDefinition = "VARCHAR(26)")
	private String name;
	
	@ManyToMany(targetEntity = Style.class, fetch = FetchType.EAGER)
	@JoinTable(name = "theme_style", joinColumns = @JoinColumn(name = "style_id"), inverseJoinColumns = @JoinColumn(name = "theme_id"))
	private Set <Style> styles;

	public Theme() 
	{
		// Do Nothing
	}

	public Long getThemeId() {
		return themeId;
	}

	public void setThemeId(Long themeId) {
		this.themeId = themeId;
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