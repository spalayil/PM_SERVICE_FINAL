package com.fse.projectmanager.contoller;

import com.fse.projectmanager.builders.RequestBuilder;
import com.fse.projectmanager.builders.ResponseBuilder;
import com.fse.projectmanager.entity.Task;
import com.fse.projectmanager.model.TaskModel;
import com.fse.projectmanager.service.ProjectService;
import com.fse.projectmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/projectmanager/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    RequestBuilder requestBuilder;

    @Autowired
    ResponseBuilder responseBuilder;

    @PostMapping("/addTask")
    public Task addTask(@RequestBody TaskModel taskModel) {
        return 	taskService.addTask(requestBuilder.buildAddTaskRquest(taskModel));
    }

    @PutMapping("/updateTask")
    public Task updateTask( @RequestBody TaskModel taskModel) {
        return 	taskService.addTask(requestBuilder.buildAddTaskRquest(taskModel));
    }


    @GetMapping("/viewTasks")
    public List<TaskModel> viewTasks() {
        return responseBuilder.buildViewTasksResponse(taskService.viewTasks());
    }



    @PutMapping("/endTask")
    public Task endTask( @RequestBody TaskModel taskModel) {
        return 	taskService.addTask(requestBuilder.buildEndTaskRequest(taskModel));
    }



    @GetMapping("/validateParentTask/{task}")
    public Integer validateParentTask( @PathVariable String task ) {
        Task taskData = taskService.validateParentTask(task);
        return taskData != null  && taskData.getTaskId() != null ? taskData.getTaskId() : null;
    }



}
