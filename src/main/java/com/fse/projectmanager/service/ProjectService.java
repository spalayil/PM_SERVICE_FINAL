package com.fse.projectmanager.service;

import com.fse.projectmanager.entity.Project;
import com.fse.projectmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepo;


    public Project addProject(Project project) {
        return this.projectRepo.save(project);
    }

    public List<Project> viewProjects() {
        return this.projectRepo.findAll();
    }

    public String deleteProject(Integer projectId) {
        try {
            this.projectRepo.deleteById(projectId);
            return "Project deleted successfully";
        } catch (Exception e) {
            return "Error while deleting user";
        }
    }

    public Project findProjectById(Integer projectId) {

        return this.projectRepo.findByProjectId(projectId);
    }



}
