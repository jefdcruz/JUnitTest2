package com.sample.dao;

public class HumanDuplicateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2880535714865073624L;
	
	public HumanDuplicateException(){
		super("Human already exists.");
	}
	
	public HumanDuplicateException(String s){
		super(s);
	}
}
