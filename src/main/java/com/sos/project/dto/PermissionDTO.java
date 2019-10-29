package com.sos.project.dto;

import com.sos.project.entity.security.Permission;

public class PermissionDTO {

	private Long permissionId;
	private String permissionName;
	
	public PermissionDTO(Long permissionId, String permissionName) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public Permission toEntity()
	{
		return new Permission(this.permissionId, this.permissionName);
	}
}
