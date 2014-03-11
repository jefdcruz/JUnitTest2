package com.sample.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sample.dao.impl.HumanDaoImpl;
import com.sample.model.Human;

public class HumanDaoTest {
	private static final String EXISTING_HUMAN = "Chinie";
	private static final String NEW_HUMAN = "Sir Nowits";

	private Human existingHuman;
	private Human newHuman;
	private HumanDaoImpl humanDao;

	@Before
	public void init() {
		existingHuman = new Human(EXISTING_HUMAN, 29);
		newHuman = new Human(NEW_HUMAN, 49);
		humanDao = new HumanDaoImpl();
		humanDao.createHuman(existingHuman);
	}

	@Test
	public void humanExists() {
		assertTrue(humanDao.exists(EXISTING_HUMAN));
		assertFalse(humanDao.exists(NEW_HUMAN));
	}

	@Test
	public void createHuman() {
		humanDao.createHuman(newHuman);
		assertEquals(humanDao.findHuman(NEW_HUMAN), newHuman);
	}

	@Test(expected = HumanDuplicateException.class)
	public void createDuplicateHuman() {
		humanDao.createHuman(existingHuman);
	}
	
	@Test
	public void updateExistingHuman(){
		existingHuman.setAge(32);
		humanDao.updateHuman(existingHuman);
		assertEquals(humanDao.findHuman(EXISTING_HUMAN), existingHuman);
	}
	
	@Test(expected = HumanNotFoundException.class)
	public void updateNonExistingHuman(){
		humanDao.updateHuman(newHuman);
	}
	
	@Test
	public void removeHuman(){
		humanDao.removeHuman(existingHuman);
		assertFalse(humanDao.exists(EXISTING_HUMAN));
	}
	
	@Test(expected = HumanNotFoundException.class)
	public void removeNonExistingHuman(){
		humanDao.removeHuman(newHuman);
	}
	
	@Test
	public void findExistingHuman(){
		assertEquals(humanDao.findHuman(EXISTING_HUMAN), existingHuman);
	}
	
	@Test(expected = HumanNotFoundException.class)
	public void findNonExistingHuman(){
		humanDao.findHuman(NEW_HUMAN);
	}
}
