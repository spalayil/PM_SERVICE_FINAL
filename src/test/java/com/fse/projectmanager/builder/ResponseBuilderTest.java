package com.fse.projectmanager.builder;


import com.fse.projectmanager.builders.ResponseBuilder;
import com.fse.projectmanager.entity.Project;
import com.fse.projectmanager.entity.Task;
import com.fse.projectmanager.entity.User;
import com.fse.projectmanager.model.ProjectModel;
import com.fse.projectmanager.model.TaskModel;
import com.fse.projectmanager.model.UserModel;
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
public class ResponseBuilderTest {

    @InjectMocks
    public ResponseBuilder responseBuilder;

    @Mock
    TaskService taskService;

    @Mock
    ProjectService projectService;

    @Test
    public void buildViewUsersResponseTest(){
        final List<UserModel> userModels = responseBuilder.buildViewUsersResponse(TestUtils.getUserList());
        assertUsers(userModels, TestUtils.getUserList());
    }

    public void assertUsers(List<UserModel> userModels, List<User> users) {
        Assert.assertEquals(users.size(), userModels.size());
        for (int i=0; i<users.size(); i++) {
            User user = users.get(i);
            UserModel userModel = userModels.get(i);
            Assert.assertEquals(user.getUserId(),userModel.getUserID());
            Assert.assertEquals(user.getEmployeeId(),userModel.getEmployeeID());
            Assert.assertEquals(user.getFirstName(),userModel.getFirstName());
            Assert.assertEquals(user.getLastName(),userModel.getLastName());
            Assert.assertEquals(user.getLastName(),userModel.getLastName());
        }

    }

    @Test
    public void buildViewProjectsResponseTest(){
        final List<ProjectModel> projectModels = responseBuilder.buildViewProjectsResponse(TestUtils.getProjectList());
        assertProjects(projectModels, TestUtils.getProjectList());

    }

    public void assertProjects(List<ProjectModel> projectModels, List<Project> projects) {
        Assert.assertEquals(projects.size(), projectModels.size());
        for (int i=0; i<projects.size(); i++) {
            Project project = projects.get(i);
            ProjectModel projectModel = projectModels.get(i);
            Assert.assertEquals(project.getProjectId(),projectModel.getProjectID());
            Assert.assertEquals(project.getStartDate(),projectModel.getStartDate());
            Assert.assertEquals(project.getEndDate(),projectModel.getEndDate());
            Assert.assertEquals(project.getPriority(),projectModel.getPriority());
        }

    }

    @Test
    public void buildViewTasksResponse(){
        Mockito.when(projectService.findProjectById(Mockito.anyInt())).thenReturn(TestUtils.getProject());
        final List<TaskModel> taskModels = responseBuilder.buildViewTasksResponse(TestUtils.getTaskList());
        assertTasks(taskModels, TestUtils.getTaskList());

    }

    public void assertTasks(List<TaskModel> taskModels, List<Task> taskList) {
        Assert.assertEquals(taskModels.size(), taskList.size());
        for (int i=0; i<taskList.size(); i++ ) {
            Task task = taskList.get(i);
            TaskModel taskModel = taskModels.get(i);
            Assert.assertEquals(task.getTaskId(), taskModel.getTaskID());
            Assert.assertEquals(task.getUserId(), taskModel.getUserID());
            Assert.assertEquals(task.getProjectId(), taskModel.getProjectID());

        }

    }
}
