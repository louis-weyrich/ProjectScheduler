package com.sos.project.entity.security;
 
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sos.project.entity.enumeration.RoleType;
import com.sos.project.entity.enumeration.RoleTypeConverter;


@Table(name = "permission", schema = "project_scheduler")
@Entity(name="Permission")
public class Permission 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="permission_id", nullable = false, updatable = false)
	private Long permissionId;
	
	@Column(name="permission_name", length = 48, nullable = false, unique = true, columnDefinition = "varchar(48)")
	private String permissionName;
	
	@Convert(converter=RoleTypeConverter.class)
	@Enumerated(EnumType.STRING)
	@Column(name="permission_type", length = 16, nullable = false, columnDefinition = "varchar(16)")
	private RoleType roleType;
	
	public Permission()
	{
		// empty constructor
	}

	public Permission(Long permissionId, String permissionName) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
	}


	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public RoleType getRoleType()
	{
		return roleType;
	}

	public void setRoleType(RoleType roleType)
	{
		this.roleType = roleType;
	}

}
