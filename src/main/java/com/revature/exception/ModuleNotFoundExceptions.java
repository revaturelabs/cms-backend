package com.revature.exception;

public class ModuleNotFoundExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	long id;
	String name;
	
	public ModuleNotFoundExceptions(long id) {
		System.out.println("Module " + id + " not found");
	}

	public ModuleNotFoundExceptions(String name) {
		System.out.println("Module " + name + " not found");
	}
}
