package com.revature.exception;

public class TagNotFoundExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	long id;
	String name;
	
	public TagNotFoundExceptions(long id) {
		System.out.println("Tag " + id + " not found");
	}

	public TagNotFoundExceptions(String name) {
		System.out.println("Tag " + name + " not found");
	}
}
