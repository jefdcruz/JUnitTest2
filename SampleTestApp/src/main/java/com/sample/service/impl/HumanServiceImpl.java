package com.sample.service.impl;

import com.sample.dao.HumanAgeException;
import com.sample.dao.HumanDao;
import com.sample.model.Human;
import com.sample.service.HumanService;

public class HumanServiceImpl implements HumanService {

	private HumanDao humanDao;

	public HumanServiceImpl(HumanDao humanDao) {
		this.humanDao = humanDao;
	}

	@Override
	public void createHuman(String name) {
		humanDao.createHuman(new Human(name, 0));
	}

	@Override
	public void removeHuman(String name) {
		Human human = humanDao.findHuman(name);
		humanDao.removeHuman(human);
	}

	@Override
	public void addAge(String name, int age) {
		Human human = humanDao.findHuman(name);
		human.setAge(human.getAge() + age);
		humanDao.updateHuman(human);
	}

	@Override
	public void decreaseAge(String name, int age) {
		Human human = humanDao.findHuman(name);
		if (human.getAge() < age) {
			throw new HumanAgeException();
		}
		human.setAge(human.getAge() - age);
		humanDao.updateHuman(human);
	}

	@Override
	public int getAge(String name) {
		return humanDao.findHuman(name).getAge();
	}

}
