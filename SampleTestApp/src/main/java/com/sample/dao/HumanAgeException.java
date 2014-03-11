package com.sample.dao;

public class HumanAgeException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4921132651518092364L;

	public HumanAgeException(){
		super("Error updating human age.");
	}
	
	public HumanAgeException(String s){
		super(s);
	}
}
