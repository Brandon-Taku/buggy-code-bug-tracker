package com.brandon.bugtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandon.bugtracker.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
