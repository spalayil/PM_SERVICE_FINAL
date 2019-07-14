package com.fse.projectmanager.builders;

import com.fse.projectmanager.entity.Project;
import com.fse.projectmanager.entity.Task;
import com.fse.projectmanager.entity.User;
import com.fse.projectmanager.model.ProjectModel;
import com.fse.projectmanager.model.TaskModel;
import com.fse.projectmanager.model.UserModel;
import com.fse.projectmanager.service.ProjectService;
import com.fse.projectmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResponseBuilder {

    @Autowired
    TaskService taskService;

    @Autowired
    ProjectService projectService;

    public List<UserModel> buildViewUsersResponse(List<User> users) {
        List<UserModel> userList=new ArrayList<>() ;
        users.forEach(item->{
            UserModel userModel=new UserModel();
            userModel.setFirstName(item.getFirstName());
            userModel.setLastName(item.getLastName());
            userModel.setEmployeeID(item.getEmployeeId());
            userModel.setUserID(item.getUserId());
            userList.add(userModel);
        });
        return userList;
    }

    public List<ProjectModel> buildViewProjectsResponse(List<Project> projects) {
        List<ProjectModel> projectList=new ArrayList<>() ;
        projects.forEach(item->{
            ProjectModel projectModel=new ProjectModel();
            projectModel.setProject(item.getProject());
            projectModel.setPriority(item.getPriority());
            projectModel.setStartDate(item.getStartDate());
            projectModel.setEndDate(item.getEndDate());
            projectModel.setProjectID(item.getProjectId());
            projectModel.setManager(item.getManager());
            projectModel.setActiveFlag(item.getActiveFlag());
            projectModel.setNoOfTasks(taskService.getTaskCount(item.getProjectId()));
            projectModel.setCompletedTasks(taskService.getCompletedTasksCount(item.getProjectId()));
            projectList.add(projectModel);
        });
        return projectList;
    }

    public List<TaskModel> buildViewTasksResponse(List<Task> tasks) {
        List<TaskModel> taskList=new ArrayList<>() ;
        tasks.forEach(item->{
            TaskModel taskmodel=new TaskModel();
            taskmodel.setTask(item.getTask());
            taskmodel.setPriority(item.getPriority());
            taskmodel.setStartDate(item.getStartDate());
            taskmodel.setEndDate(item.getEndDate());
            taskmodel.setTaskID(item.getTaskId());
            taskmodel.setUserID(item.getUserId());
            taskmodel.setProjectID(item.getProjectId());
            if(null!=item.getParentTask() && null != item.getParentTask().getParentId()) {
                taskmodel.setParentTaskID(item.getParentTask().getParentId());
                taskmodel.setParentTask(item.getParentTask().getParentTask());
            }
            taskmodel.setActiveFlag(item.getActiveFlag());
            Project project = projectService.findProjectById(item.getProjectId());
            taskmodel.setProject(project.getProject());
            taskList.add(taskmodel);
        });
        return taskList;
    }
}
