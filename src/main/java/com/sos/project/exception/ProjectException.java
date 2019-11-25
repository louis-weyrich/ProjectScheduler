package com.sos.project.exception;

import com.sos.project.dto.ProjectDTO;

public class ProjectException extends RuntimeException 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4207483267956856275L;
	private ProjectDTO project;

	public ProjectException() {
		// Do Nothing
	}
	
	public ProjectException(ProjectDTO project) {
		this.project = project;
	}

	public ProjectException(String message) {
		super(message);
		
	}
	

	public ProjectException(ProjectDTO project, String message) {
		super(message);
		this.project = project;
	}


	public ProjectException(Throwable cause) {
		super(cause);
		
	}

	public ProjectException(ProjectDTO project, String message, Throwable cause) {
		super(message, cause);
		this.project = project;
	}
	

	public ProjectException(String message, Throwable cause) {
		super(message, cause);
		
	}


	public ProjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}
	
	public ProjectDTO getPRoject()
	{
		return this.project;
	}

}
