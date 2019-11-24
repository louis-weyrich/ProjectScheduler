package com.sos.project.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice()
public class ProjectControllerAdvice extends ResponseEntityExceptionHandler {

	public ProjectControllerAdvice() {
		// TODO Auto-generated constructor stub
	}

}
