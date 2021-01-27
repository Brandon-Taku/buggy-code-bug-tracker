package com.brandon.bugtracker.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.bugtracker.model.Project;
import com.brandon.bugtracker.repository.ProjectInterface;
import com.brandon.bugtracker.repository.ProjectRepository;


@Transactional
@Service
public class ProjectImpl implements ProjectInterface {

	@Autowired
	private ProjectRepository projectRepo;
	
	
	@Override
	public void delete(long id) {
		projectRepo.deleteById(id);
	}

	@Override
	public Project getProjectById(long id) {
		
		Optional <Project> optional = projectRepo.findById(id);
		Project project = null;
        if (optional.isPresent()) {
            project = optional.get();
        } else {
            throw new RuntimeException(" Project not found for id :: " + id);
        }
        return project;
        
	}

	@Override
	public void saveProject(Project project) {
		this.projectRepo.save(project);
	}

}
