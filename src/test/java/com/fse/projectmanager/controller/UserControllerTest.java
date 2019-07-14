package com.fse.projectmanager.controller;

import com.fse.projectmanager.TestConfiguration;
import com.fse.projectmanager.builders.RequestBuilder;
import com.fse.projectmanager.entity.User;
import com.fse.projectmanager.model.UserModel;
import com.fse.projectmanager.service.UserService;
import com.fse.projectmanager.contoller.UserController;
import com.fse.projectmanager.util.TestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(classes = {TestConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    public UserController userController;

    @Mock
    public UserService userService;

    @Autowired
    public RequestBuilder requestBuilder;
/*
    @Test
    public void saveUserTest(){

        Mockito.when(userService.addUser(Mockito.any(User.class))).thenReturn(TestUtils.getUser());
        User output = userController.addUser(TestUtils.getUserModel());

        Assert.assertEquals(TestUtils.getUser().getUserId(), output.getUserId());

    }

    @Test
    public void getAllUsersTest(){

        Mockito.when(userService.viewUsers()).thenReturn(TestUtils.getUserList());

        List<UserModel> output = userController.viewUsers();

        Assert.assertEquals(2, output.size());
    }

    @Test
    public void editUserTest(){

        Mockito.when(userService.addUser(Mockito.any(User.class))).thenReturn(TestUtils.getUser());
        User output = userController.editUser(TestUtils.getUserModel());

        Assert.assertEquals(TestUtils.getUser().getUserId(),output.getUserId());
        Assert.assertEquals(TestUtils.getUser().getFirstName(),output.getFirstName());
        Assert.assertEquals(TestUtils.getUser().getLastName(),output.getLastName());
        Assert.assertEquals(TestUtils.getUser().getEmployeeId(),output.getEmployeeId());
    }

    @Test
    public void deleteUserTest(){

        Mockito.when(userService.deleteUser(Mockito.anyInt())).thenReturn("User deleted successfully");

        String output = userController.deleteUser(1);

        Assert.assertEquals("User deleted successfully", output);
    }*/
}
