package com.fse.projectmanager.builder;

import com.fse.projectmanager.builders.RequestBuilder;
import com.fse.projectmanager.entity.ParentTask;
import com.fse.projectmanager.entity.Project;
import com.fse.projectmanager.entity.Task;
import com.fse.projectmanager.entity.User;
import com.fse.projectmanager.model.ProjectModel;
import com.fse.projectmanager.model.TaskModel;
import com.fse.projectmanager.model.UserModel;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RequestBuilderTest {

    @Mock
    TaskService taskService;

    @InjectMocks
    RequestBuilder requestBuilder;

    @Test
    public void buildAddUserRequestTest(){
        final UserModel userModel = TestUtils.getUserModel();
        User user = requestBuilder.buildAddUserRequest(userModel);
        Assert.assertEquals(user.getUserId(), userModel.getUserID());
        Assert.assertEquals(user.getLastName(), userModel.getLastName());
        Assert.assertEquals(user.getFirstName(), userModel.getFirstName());
        Assert.assertEquals(user.getEmployeeId(), userModel.getEmployeeID());
    }

    @Test
    public void buildProjectRequestTest(){
        ProjectModel projectModel = TestUtils.getProjectModel();
        Project project = requestBuilder.buildProjectRequest(projectModel);
        Assert.assertEquals(project.getProjectId(), projectModel.getProjectID());
        Assert.assertEquals(project.getPriority(), projectModel.getPriority());
        Assert.assertEquals(project.getEndDate(), projectModel.getEndDate());
        Assert.assertEquals(project.getStartDate(), projectModel.getStartDate());
    }

    @Test
    public void buildAddTaskRequestTest(){
        Mockito.when(taskService.addParentTask(Mockito.any(ParentTask.class))).thenReturn(TestUtils.getParentTask());
        TaskModel taskModel = TestUtils.getTaskModel();
        Task task = requestBuilder.buildAddTaskRequest(taskModel);
        Assert.assertEquals(task.getUserId(), taskModel.getUserID());
        Assert.assertEquals(task.getProjectId(), taskModel.getProjectID());
        Assert.assertEquals(task.getActiveFlag(), taskModel.getActiveFlag());
    }

    @Test
    public void buildEndTaskRequestTest(){
        TaskModel taskModel = TestUtils.getTaskModel();
        Task task = requestBuilder.buildEndTaskRequest(taskModel);
        Assert.assertNotEquals(task.getActiveFlag(), taskModel.getActiveFlag());

    }


}
