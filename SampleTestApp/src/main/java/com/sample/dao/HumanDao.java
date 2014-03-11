package com.sample.dao;

import com.sample.model.Human;

public interface HumanDao {
	public void createHuman(Human human);
	public void updateHuman(Human human);
	public void removeHuman(Human human);
	public Human findHuman(String name);
}
