package com.fse.projectmanager.controller;

import com.fse.projectmanager.builders.RequestBuilder;
import com.fse.projectmanager.builders.ResponseBuilder;
import com.fse.projectmanager.contoller.TaskController;
import com.fse.projectmanager.entity.ParentTask;
import com.fse.projectmanager.entity.Task;
import com.fse.projectmanager.model.TaskModel;
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
public class TaskControllerTest {

    @InjectMocks
    public TaskController taskController;

    @Mock
    public TaskService taskService;

    @Mock
    public ProjectService projectService;

    @Mock
    public RequestBuilder requestBuilder;

    @Mock
    ResponseBuilder responseBuilder;

    @Test
    public void saveTaskTest(){

        Mockito.when(taskService.addTask(Mockito.any(Task.class))).thenReturn(TestUtils.getTask());
        Mockito.when(taskService.addParentTask(Mockito.any(ParentTask.class))).thenReturn(TestUtils.getParentTask());
        Mockito.when(requestBuilder.buildAddTaskRequest(Mockito.any(TaskModel.class))).thenReturn(TestUtils.getTask());
        Task output = taskController.addTask(TestUtils.getTaskModel());
        Assert.assertEquals(TestUtils.getTask().getTaskId(), output.getTaskId());

    }

    @Test
    public void getAllTasksTest(){
        Mockito.when(taskService.viewTasks()).thenReturn(TestUtils.getTaskList());
        Mockito.when(projectService.findProjectById(Mockito.anyInt())).thenReturn(TestUtils.getProject());
        Mockito.when(responseBuilder.buildViewTasksResponse(Mockito.any(List.class)))
                .thenReturn(TestUtils.getTaskList());
        List<TaskModel> output = taskController.viewTasks();
        Assert.assertEquals(2, output.size());
    }

    @Test
    public void editTaskTest(){
        Mockito.when(taskService.addTask(Mockito.any(Task.class))).thenReturn(TestUtils.getTask());
        Mockito.when(taskService.addParentTask(Mockito.any(ParentTask.class))).thenReturn(TestUtils.getParentTask());
        Mockito.when(requestBuilder.buildAddTaskRequest(Mockito.any(TaskModel.class))).thenReturn(TestUtils.getTask());
        Task output = taskController.updateTask(TestUtils.getTaskModel());
        Assert.assertEquals(TestUtils.getTask().getTaskId(), output.getTaskId());
        Assert.assertEquals(TestUtils.getTask().getTaskId(),output.getTaskId());
        Assert.assertEquals(TestUtils.getTask().getTask(),output.getTask());
    }

    @Test
    public void endTask(){
        Mockito.when(taskService.addTask(Mockito.any(Task.class))).thenReturn(TestUtils.getTask());
        Mockito.when(requestBuilder.buildEndTaskRequest(Mockito.any(TaskModel.class))).thenReturn(TestUtils.getTask());
        Task output = taskController.endTask(TestUtils.getTaskModel());
        Assert.assertEquals(TestUtils.getTask().getTaskId(), output.getTaskId());
    }
}
