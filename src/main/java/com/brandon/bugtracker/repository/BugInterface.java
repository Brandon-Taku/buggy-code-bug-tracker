package com.brandon.bugtracker.repository;

import com.brandon.bugtracker.model.Bug;
import com.brandon.bugtracker.model.Employees;

public interface BugInterface {
	
	public void delete(long id);
	
	public Bug getBugById(long id);
	
	void saveBug(Bug bug);

}
