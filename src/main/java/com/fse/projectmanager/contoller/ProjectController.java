package com.fse.projectmanager.contoller;

import com.fse.projectmanager.builders.RequestBuilder;
import com.fse.projectmanager.builders.ResponseBuilder;
import com.fse.projectmanager.entity.Project;
import com.fse.projectmanager.model.ProjectModel;
import com.fse.projectmanager.service.ProjectService;
import com.fse.projectmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/projectmanager/project")
public class ProjectController {


    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @Autowired
    RequestBuilder requestBuilder;

    @Autowired
    ResponseBuilder responseBuilder;


    @PostMapping("/addProject")
    public Project addProject(@RequestBody ProjectModel projectModel) {
        return 	projectService.addProject(requestBuilder.buildProjectRequest(projectModel));
    }

    @PutMapping("/editProject")
    public Project editProject( @RequestBody ProjectModel projectModel) {
        return 	projectService.addProject(requestBuilder.buildProjectRequest(projectModel));
    }

    @GetMapping("/viewProjects")
    public List<ProjectModel> viewProjects() {
        return responseBuilder.buildViewProjectsResponse(projectService.viewProjects());
    }

    @DeleteMapping("/deleteProject/{projectId}")
    public String deleteProject( @PathVariable Integer projectId) {
        return 	projectService.deleteProject(projectId);
    }


}
