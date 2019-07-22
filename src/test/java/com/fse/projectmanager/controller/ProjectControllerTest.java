package com.fse.projectmanager.controller;


import com.fse.projectmanager.builders.RequestBuilder;
import com.fse.projectmanager.builders.ResponseBuilder;
import com.fse.projectmanager.contoller.ProjectController;
import com.fse.projectmanager.entity.Project;
import com.fse.projectmanager.model.ProjectModel;
import com.fse.projectmanager.service.ProjectService;
import com.fse.projectmanager.service.TaskService;
import com.fse.projectmanager.util.TestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProjectControllerTest {

    @InjectMocks
    public ProjectController projectController;

    @Mock
    public ProjectService projectService;

    @Mock
    public TaskService taskService;

    @Mock
    public RequestBuilder requestBuilder;

    @Mock
    ResponseBuilder responseBuilder;

    @Test
    public void saveProjectTest(){

        Mockito.when(projectService.addProject(Mockito.any(Project.class))).thenReturn(TestUtils.getProject());
        Mockito.when(requestBuilder.buildProjectRequest(Mockito.any(ProjectModel.class)))
                .thenReturn(TestUtils.getProject());
        Project output = projectController.addProject(TestUtils.getProjectModel());
        Assert.assertEquals(TestUtils.getProject().getProjectId(), output.getProjectId());

    }

    @Test
    public void getAllProjectsTest(){

        Mockito.when(projectService.viewProjects()).thenReturn(TestUtils.getProjectList());
        Mockito.when(responseBuilder.buildViewProjectsResponse(Mockito.any(List.class)))
                .thenReturn(TestUtils.getProjectList());
        Mockito.when(taskService.getCompletedTasksCount(Mockito.anyInt())).thenReturn(1);
        Mockito.when(taskService.getTaskCount(Mockito.anyInt())).thenReturn(1);
        List<ProjectModel> output = projectController.viewProjects();
        Assert.assertEquals(2, output.size());
    }

    @Test
    public void editProjectTest(){

        Mockito.when(projectService.addProject(Mockito.any(Project.class))).thenReturn(TestUtils.getProject());
        Mockito.when(requestBuilder.buildProjectRequest(Mockito.any(ProjectModel.class)))
                .thenReturn(TestUtils.getProject());
        Project output = projectController.editProject(TestUtils.getProjectModel());
        Assert.assertEquals(TestUtils.getProject().getProjectId(), output.getProjectId());
        Assert.assertEquals(TestUtils.getProject().getProject(),output.getProject());
    }

    @Test
    public void deleteProjectTest(){
        Mockito.when(projectService.deleteProject(Mockito.anyInt())).thenReturn("Project deleted successfully");
        String output = projectController.deleteProject(1);
        Assert.assertEquals("Project deleted successfully", output);
    }

}
