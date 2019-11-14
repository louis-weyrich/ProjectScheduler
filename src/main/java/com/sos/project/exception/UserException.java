package com.sos.project.exception;
 
import com.sos.project.dto.security.UserDTO;

public class UserException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5558332486007675894L;
	private UserDTO user;

	public UserException(UserDTO user) {
		this.user = user;
	}

	public UserException(String message) {
		super(message);
	}
	
	public UserException(UserDTO user, String message) {
		super(message);
		this.user = user;
	}

	public UserException(UserDTO user, Throwable cause) {
		super(cause);
		this.user = user;
	}

	public UserException(UserDTO user, String message, Throwable cause) {
		super(message, cause);
		this.user = user;
	}

	public UserException(UserDTO user, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.user = user;
	}

	public UserDTO getUser() {
		return user;
	}

	

}
