package com.sos.project.repository.security;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sos.project.entity.security.AuthenticatedUser;

@Repository
public interface UserRepository 
extends JpaRepository<AuthenticatedUser, Long>, PagingAndSortingRepository<AuthenticatedUser, Long> 
{

	@Query("SELECT au FROM AuthenticatedUser au WHERE au.userName = :username")
	public AuthenticatedUser getUserByUsername(@Param("username") String username);
	
	@Query("SELECT au FROM AuthenticatedUser au WHERE au.status = true")
	public Page<AuthenticatedUser> findAllActiveUsers(Pageable pageable);
}
