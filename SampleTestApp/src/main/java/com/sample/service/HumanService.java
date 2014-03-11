package com.sample.service;

public interface HumanService {
	public void createHuman(String name);

	public void removeHuman(String name);

	public void addAge(String name, int age);

	public void decreaseAge(String name, int age);

	public int getAge(String name);
}
