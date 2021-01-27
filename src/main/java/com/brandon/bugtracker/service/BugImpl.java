package com.brandon.bugtracker.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.bugtracker.model.Bug;
import com.brandon.bugtracker.model.Project;
import com.brandon.bugtracker.repository.BugInterface;
import com.brandon.bugtracker.repository.BugRepository;


@Transactional
@Service
public class BugImpl implements BugInterface {
	
	
	@Autowired
	private BugRepository bugRepo;

	@Override
	public void delete(long id) {
		bugRepo.deleteById(id);

	}

	@Override
	public Bug getBugById(long id) {
		
		Optional <Bug> optional = bugRepo.findById(id);
		Bug bug = null;
        if (optional.isPresent()) {
            bug = optional.get();
        } else {
            throw new RuntimeException("Bug not found for id :: " + id);
        }
        return bug;
	}

	@Override
	public void saveBug(Bug bug) {
		this.bugRepo.save(bug);

	}

}
