package com.sos.project.entity.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StyleTypeConverter implements AttributeConverter<StyleType, String>
{

	public StyleTypeConverter()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public String convertToDatabaseColumn(StyleType attribute)
	{
		return attribute.name();
	}

	@Override
	public StyleType convertToEntityAttribute(String dbData)
	{
		return StyleType.valueOf(dbData);
	}


}
