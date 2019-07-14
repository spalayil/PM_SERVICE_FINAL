package com.fse.projectmanager.builders;

import com.fse.projectmanager.entity.ParentTask;
import com.fse.projectmanager.entity.Project;
import com.fse.projectmanager.entity.Task;
import com.fse.projectmanager.entity.User;
import com.fse.projectmanager.model.ProjectModel;
import com.fse.projectmanager.model.TaskModel;
import com.fse.projectmanager.model.UserModel;
import com.fse.projectmanager.service.TaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class RequestBuilder {

    @Autowired
    TaskService taskService;

    public User buildAddUserRequest(UserModel userModel) {
        User newUser = new User();
        if (userModel.getUserID() != null) {
            newUser.setUserId(userModel.getUserID());
        }
        newUser.setFirstName(userModel.getFirstName());
        newUser.setLastName(userModel.getLastName());
        newUser.setEmployeeId(userModel.getEmployeeID());
        return newUser;
    }

    public Project buildProjectRequest(@RequestBody ProjectModel projectModel) {
        Project newProject = new Project();
        if (projectModel.getProjectID() != null) {
            newProject.setProjectId(projectModel.getProjectID());
        }
        newProject.setProject(projectModel.getProject());
        newProject.setStartDate(projectModel.getStartDate());
        newProject.setEndDate(projectModel.getEndDate());
        newProject.setPriority(projectModel.getPriority());
        newProject.setManager(projectModel.getManager());
        newProject.setActiveFlag(true);
        return newProject;
    }

    public Task buildAddTaskRquest(@RequestBody TaskModel taskModel) {
        Task newTask = new Task();
        if(taskModel.getTaskID() != null) {
            newTask.setTaskId(taskModel.getTaskID());
        }
        newTask.setTask(taskModel.getTask());
        newTask.setStartDate(taskModel.getStartDate());
        newTask.setEndDate(taskModel.getEndDate());
        newTask.setPriority(taskModel.getPriority());
        newTask.setActiveFlag(true);
        newTask.setUserId(taskModel.getUserID());
        newTask.setProjectId(taskModel.getProjectID());
        if(StringUtils.isNotBlank(taskModel.getParentTask())) {
            ParentTask newParentTask = new ParentTask();
            newParentTask.setParentTask(taskModel.getParentTask());
            newParentTask.setParentId(taskModel.getParentTaskID());
            newParentTask = taskService.addParentTask(newParentTask);
            newTask.setParentId(newParentTask.getParentId());
        }
        return newTask;
    }

    public Task buildEndTaskRequest(@RequestBody TaskModel taskModel) {
        Task task = new Task();
        task.setTask(taskModel.getTask());
        task.setStartDate(taskModel.getStartDate());
        task.setEndDate(taskModel.getEndDate());
        task.setPriority(taskModel.getPriority());
        task.setTaskId(taskModel.getTaskID());
        task.setParentId(taskModel.getParentTaskID());
        task.setUserId(taskModel.getUserID());
        task.setProjectId(taskModel.getProjectID());
        task.setActiveFlag(false);
        return task;
    }
}
