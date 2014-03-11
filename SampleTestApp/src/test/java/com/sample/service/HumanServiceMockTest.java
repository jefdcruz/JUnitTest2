package com.sample.service;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.sample.dao.HumanAgeException;
import com.sample.dao.HumanDao;
import com.sample.model.Human;
import com.sample.service.impl.HumanServiceImpl;

public class HumanServiceMockTest {
	private static final String HUMAN_NAME = "Sir Nowi";
	private HumanDao humanDao;
	private HumanService humanService;
	
	@Before
	public void init(){
		humanDao = EasyMock.createMock(HumanDao.class);
		humanService = new HumanServiceImpl(humanDao);
	}
	
	@Test
	public void addAge(){
		Human human = new Human(HUMAN_NAME, 40);
		humanDao.createHuman(human);
		humanDao.findHuman(HUMAN_NAME);
		EasyMock.expectLastCall().andReturn(human);
		human.setAge(50);
		humanDao.updateHuman(human);
		EasyMock.replay(humanDao);
		
		humanService.addAge(HUMAN_NAME, 10);
		EasyMock.verify();
	}
	
	@Test
	public void decreaseSufficientAge(){
		Human human = new Human(HUMAN_NAME, 40);
		humanDao.findHuman(HUMAN_NAME);
		EasyMock.expectLastCall().andReturn(human);
		human.setAge(50);
		humanDao.updateHuman(human);
		EasyMock.replay(humanDao);
		
		humanService.decreaseAge(HUMAN_NAME, 20);
		EasyMock.verify();
	}
	
	@Test(expected = HumanAgeException.class)
	public void decreaseInsufficientAge(){
		Human human = new Human(HUMAN_NAME, 40);
		humanDao.findHuman(HUMAN_NAME);
		EasyMock.expectLastCall().andReturn(human);
		human.setAge(50);
		humanDao.updateHuman(human);
		EasyMock.replay(humanDao);
		
		humanService.decreaseAge(HUMAN_NAME, 60);
		EasyMock.verify();
	}
}
