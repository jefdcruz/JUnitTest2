package com.sample.service;

import com.sample.model.Human;

public interface HumanService {
	public void createHuman(Human human);
	public void removeHuman(Human human);
	public int findAge(String name);
}
