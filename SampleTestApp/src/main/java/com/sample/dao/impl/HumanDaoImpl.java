package com.sample.dao.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.sample.dao.HumanDao;
import com.sample.dao.HumanDuplicateException;
import com.sample.dao.HumanNotFoundException;
import com.sample.model.Human;

public class HumanDaoImpl implements HumanDao {

	private Map<String, Human> humans;

	public HumanDaoImpl() {
		this.humans = Collections.synchronizedMap(new HashMap<String, Human>());
	}

	public boolean exists(String name){
		return humans.containsKey(name);
	}
	
	@Override
	public void createHuman(Human human) throws HumanDuplicateException  {
		if(exists(human.getName())){
			throw new HumanDuplicateException();
		}
		humans.put(human.getName(), human);
	}

	@Override
	public void updateHuman(Human human) throws HumanNotFoundException{
		if(!exists(human.getName())){
			throw new HumanNotFoundException();
		}
		humans.put(human.getName(), human);
	}

	@Override
	public void removeHuman(Human human) throws HumanNotFoundException {
		if(!exists(human.getName())){
			throw new HumanNotFoundException();
		}
		humans.remove(human.getName());
	}

	@Override
	public Human findHuman(String name) throws HumanNotFoundException {
		Human human = humans.get(name);
		if(human == null){
			throw new HumanNotFoundException();
		}
		return human;
	}

}
