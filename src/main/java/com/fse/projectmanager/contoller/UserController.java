package com.fse.projectmanager.contoller;

import com.fse.projectmanager.builders.RequestBuilder;
import com.fse.projectmanager.builders.ResponseBuilder;
import com.fse.projectmanager.entity.User;
import com.fse.projectmanager.model.UserModel;
import com.fse.projectmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projectmanager/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RequestBuilder requestBuilder;

    @Autowired
    private ResponseBuilder responseBuilder;

    @PostMapping("/addUser")
    public User addUser(@RequestBody UserModel userModel) {
        return 	userService.addUser(requestBuilder.buildAddUserRequest(userModel));
    }

    @PutMapping("/editUser")
    public User editUser( @RequestBody UserModel userModel) {
        return 	userService.addUser(requestBuilder.buildAddUserRequest(userModel));
    }

    @GetMapping("/viewUsers")
    public List<UserModel> viewUsers() {
        return responseBuilder.buildViewUsersResponse(userService.viewUsers());
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser( @PathVariable Integer userId) {
        return 	userService.deleteUser(userId);
    }




}
