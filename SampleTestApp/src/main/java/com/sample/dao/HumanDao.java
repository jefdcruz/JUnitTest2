package com.sample.dao;

import com.sample.model.Human;

public interface HumanDao {
	public void createHuman(Human human) throws HumanDuplicateException;
	public void updateHuman(Human human) throws HumanNotFoundException;
	public void removeHuman(Human human) throws HumanNotFoundException;
	public Human findHuman(String name) throws HumanNotFoundException;
}
