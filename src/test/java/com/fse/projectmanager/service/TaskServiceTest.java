package com.fse.projectmanager.service;

import com.fse.projectmanager.entity.Task;
import com.fse.projectmanager.repository.TaskRepository;
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
public class TaskServiceTest {

    @InjectMocks
    public TaskService taskService;

    @Mock
    public TaskRepository taskRepository;

    @Test
    public void addTaskTest(){
        Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenReturn(TestUtils.getTask());
        Task output = taskService.addTask(TestUtils.getTask());

        Assert.assertEquals(TestUtils.getTask().getTaskId(),output.getTaskId());
    }


    @Test
    public void viewTasksTest(){
        Mockito.when(taskRepository.findAll()).thenReturn(TestUtils.getTaskList());
        List<Task> output = taskService.viewTasks();
        Assert.assertEquals(2,output.size());
    }
}
