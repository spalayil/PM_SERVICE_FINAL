package com.fse.projectmanager.service;

import com.fse.projectmanager.entity.User;
import com.fse.projectmanager.repository.UserRepository;
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
public class UserServiceTest {

    @InjectMocks
    public UserService userService;

    @Mock
    public UserRepository userRepository;

    @Test
    public void addUserTest(){
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(TestUtils.getUser());
        User output = userService.addUser(TestUtils.getUser());
        Assert.assertEquals(TestUtils.getUser().getUserId(),output.getUserId());
    }

    @Test
    public void deleteUserTest(){
        String output = userService.deleteUser(1);
        Assert.assertEquals("User deleted successfully", output);
    }

    @Test
    public void viewUsersTest(){
        Mockito.when(userRepository.findAll()).thenReturn(TestUtils.getUserList());
        List<User> output = userService.viewUsers();
        Assert.assertEquals(2,output.size());
    }

}
