package com.brandon.bugtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brandon.bugtracker.model.Bug;
import com.brandon.bugtracker.model.User;

public interface BugRepository extends JpaRepository<Bug, Long> {
	
}
