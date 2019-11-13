package com.sos.project.entity.security;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.sos.project.dto.UserDTO;


@Table(name = "authenticated_user", schema = "project_scheduler")
@Entity(name="AuthenticatedUser")
public class AuthenticatedUser 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id", nullable = false, updatable = false)
	private Long userId;
	
	@Column(name="user_name", length = 48, nullable = false, unique = true, columnDefinition = "varchar(48)")
	private String username;
	
	@Column(name="full_name", nullable = false, length = 26, columnDefinition = "varchar(26)")
	private String fullName;
	
	@Column(name="", nullable = false, length = 64, columnDefinition = "varchar(64)")
	private String passwordHash;
	
	@Column(name="user_email", nullable = false, length = 48, unique = true, columnDefinition = "varchar(48)")
	private String email;
	
	@Column(name="phone", nullable = true, length = 22, columnDefinition = "varchar(22)")
	private String phone;
	
	@Column(name = "status", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
	@Convert(disableConversion = true)
	@Type(type = "boolean")
	private Boolean status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp()
	@Column(name = "date_active", nullable = true, columnDefinition = "TIMESTAMP")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date dateActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_deactivated", nullable = true, columnDefinition = "TIMESTAMP")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date dateDeactivated;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

	
	public AuthenticatedUser()
	{
		// empty constructor
	}
	
	public AuthenticatedUser(UserDTO user)
	{
		this.userId = user.getUserId();
    	this.username = user.getUsername();
    	this.fullName = user.getFullName();
    	this.passwordHash = user.getPasswordHash();
    	this.email = user.getEmail();
    	this.phone = user.getPhone();
    	this.status = user.getStatus();
    	this.dateActive = user.getDateActive();
    	this.dateDeactivated = user.getDateDeactivated();
	}
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getDateActive() {
		return dateActive;
	}

	public void setDateActive(Date dateActive) {
		this.dateActive = dateActive;
	}

	public Date getDateDeactivated() {
		return dateDeactivated;
	}

	public void setDateDeactivated(Date dateDeactivated) {
		this.dateDeactivated = dateDeactivated;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public int hashCode()
	{
		return username.hashCode();
	}
	
	public boolean equals(Object src)
	{
		if(src instanceof AuthenticatedUser)
		{
			return userId == ((AuthenticatedUser)src).getUserId();
		}
		
		return false;
	}
	
	public String toString()
	{
		return username;
	}
}
