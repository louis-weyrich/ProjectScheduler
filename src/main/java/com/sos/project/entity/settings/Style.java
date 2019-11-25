package com.sos.project.entity.settings;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sos.project.entity.enumeration.StyleType;
import com.sos.project.entity.enumeration.StyleTypeConverter;

public class Style {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="style_id", nullable = false, updatable = false, columnDefinition = "INT")
	private Long styleId;
	
	@Convert(converter=StyleTypeConverter.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "style_type", nullable = false, length = 10, columnDefinition = "VARCHAR(10) DEFAULT 'CLASS'")
	private StyleType type;
	
	@Column(name = "style_name", nullable = false, updatable = false, length = 32, columnDefinition = "VARCHAR(32)")
	private String name;
	
	@OneToMany(targetEntity = StyleAttribute.class)
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
