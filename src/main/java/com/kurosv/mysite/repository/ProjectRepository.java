package com.kurosv.mysite.repository;

import com.kurosv.mysite.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
