package com.sos.project.dto.security;

import java.util.HashSet;
import java.util.Set;

import com.sos.project.entity.enumeration.RoleType;
import com.sos.project.entity.security.Permission;
import com.sos.project.entity.security.Role;

public class RoleDTO
{
	
	private Long roleId;
	private String roleName;
	private RoleType roleType;
	private Set<PermissionDTO> permissions;


	public RoleDTO()
	{
		// Do Nothing
	}
	
	public RoleDTO(Role role)
	{
		this.roleId = role.getRoleId();
		this.roleName = role.getRoleName();
		this.roleType = role.getRoleType();
		this.permissions = new HashSet<PermissionDTO> (role.getPermissions().size());
		
		for(Permission permission :role.getPermissions())
		{
			permissions.add(new PermissionDTO(permission));
		}
	}

	public Long getRoleId()
	{
		return roleId;
	}

	public void setRoleId(Long roleId)
	{
		this.roleId = roleId;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	public RoleType getRoleType()
	{
		return roleType;
	}

	public void setRoleType(RoleType roleType)
	{
		this.roleType = roleType;
	}

	public Set<PermissionDTO> getPermissions()
	{
		return permissions;
	}

	public void setPermissions(Set<PermissionDTO> permissions)
	{
		this.permissions = permissions;
	}

}
