package com.joaoluis.courseudemy.services.exceptions;

public class ResourceNotFoundException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Long id) {
		super("ResouceNotFound. Id" + id);
	}
}
