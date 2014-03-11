package com.sample.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sample.dao.HumanAgeException;
import com.sample.dao.HumanDao;
import com.sample.model.Human;
import com.sample.service.impl.HumanServiceImpl;

public class HumanServiceTest {
	private static final String HUMAN_NAME = "Sir Nowi";
	private HumanDaoStub humanDaoStub;
	private HumanService humanService;

	private class HumanDaoStub implements HumanDao {
		private String name;
		private int age;

		@Override
		public void createHuman(Human human) {
		}

		@Override
		public void removeHuman(Human human) {
		}

		@Override
		public Human findHuman(String name) {
			return new Human(this.name, this.age);
		}

		@Override
		public void updateHuman(Human human) {
			this.name = human.getName();
			this.age = human.getAge();
		}

	}
	
	@Before
	public void init(){
		humanDaoStub = new HumanDaoStub();
		humanDaoStub.name = HUMAN_NAME;
		humanDaoStub.age = 10;
		humanService = new HumanServiceImpl(humanDaoStub);
	}
	
	@Test
	public void addAge(){
		humanService.addAge(HUMAN_NAME, 40);
		assertEquals(humanDaoStub.name, HUMAN_NAME);
		assertEquals(humanDaoStub.age, 50);
	}
	
	@Test
	public void decreaseAge(){
		humanService.decreaseAge(HUMAN_NAME, 5);
		assertEquals(humanDaoStub.name,HUMAN_NAME);
		assertEquals(humanDaoStub.age, 5);
	}
	
	@Test(expected = HumanAgeException.class)
	public void decreaseInsufficientAge(){
		humanService.decreaseAge(HUMAN_NAME, 15);
	}
}
