package com.brandon.bugtracker.repository;

import com.brandon.bugtracker.model.Project;

public interface ProjectInterface {
	
    public void delete(long id);
	
	public Project getProjectById(long id);
	
	void saveProject(Project project);

}
