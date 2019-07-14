package com.fse.projectmanager.repository;

import com.fse.projectmanager.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    public Project findByProjectId(Integer id);
}
