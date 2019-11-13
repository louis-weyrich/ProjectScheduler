package com.sos.project.entity.enumeration;

import javax.persistence.AttributeConverter;

public class RoleTypeConverter implements AttributeConverter<RoleType, String> {

	@Override
	public String convertToDatabaseColumn(RoleType attribute) {
		return attribute.name();
	}

	@Override
	public RoleType convertToEntityAttribute(String dbData) {
		return RoleType.valueOf(dbData);
	}

}
