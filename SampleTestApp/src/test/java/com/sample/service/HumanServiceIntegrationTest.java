package com.sample.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sample.dao.impl.HumanDaoImpl;
import com.sample.service.impl.HumanServiceImpl;

public class HumanServiceIntegrationTest {
	private static final String HUMAN_NAME = "Sir Nowi";
	private HumanService humanService;
	
	@Before
	public void init(){
		humanService = new HumanServiceImpl(new HumanDaoImpl());
		humanService.createHuman(HUMAN_NAME);
		humanService.addAge(HUMAN_NAME, 50);
	}
	
	@Test
	public void addAge(){
		humanService.addAge(HUMAN_NAME, 30);
		assertEquals(humanService.getAge(HUMAN_NAME), 80);
	}
	
	@Test
	public void decreaseAge(){
		humanService.decreaseAge(HUMAN_NAME, 20);
		assertEquals(humanService.getAge(HUMAN_NAME), 30);
	}
	
	@After
	public void cleanup(){
		humanService.removeHuman(HUMAN_NAME);
	}
}
