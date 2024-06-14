package com.jplan.jplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jplan.jplan.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {

}
