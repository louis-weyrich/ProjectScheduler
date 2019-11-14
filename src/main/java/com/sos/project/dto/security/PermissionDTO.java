package com.sos.project.dto.security;

import com.sos.project.entity.enumeration.RoleType;
import com.sos.project.entity.security.Permission;

public class PermissionDTO {

	private Long permissionId;
	private String permissionName;
	private RoleType roleType;
	
	public PermissionDTO(Long permissionId, String permissionName, RoleType roleType) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.roleType = roleType;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public RoleType getRoleType()
	{
		return roleType;
	}

	public void setRoleType(RoleType roleType)
	{
		this.roleType = roleType;
	}

	public void setPermissionId(Long permissionId)
	{
		this.permissionId = permissionId;
	}

	public void setPermissionName(String permissionName)
	{
		this.permissionName = permissionName;
	}

	public Permission toEntity()
	{
		return new Permission(this.permissionId, this.permissionName);
	}
}
