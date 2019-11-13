package com.sos.project.entity.security;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Table(name = "role", schema = "project_scheduler")
@Entity(name="Role")
public class Role 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id", nullable = false, updatable = false)
	private Long roleId;
	
	@Column(name="role_name", length = 48, nullable = false, unique = true, columnDefinition = "varchar(48)")
	private String roleName;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions;
	
	@ManyToMany(mappedBy = "roles")
	private Set<AuthenticatedUser> users;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Set<AuthenticatedUser> getUsers()
	{
		return users;
	}

	public void setUsers(Set<AuthenticatedUser> users)
	{
		this.users = users;
	}
	
	
}
