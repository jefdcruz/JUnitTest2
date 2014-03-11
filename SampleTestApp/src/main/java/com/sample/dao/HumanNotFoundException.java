package com.sample.dao;

public class HumanNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1203575669163741855L;
	
	public HumanNotFoundException(){
		super("Human does not exist.");
	}
	
	public HumanNotFoundException(String s){
		super(s);
	}
}
