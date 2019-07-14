package com.fse.projectmanager.service;

import com.fse.projectmanager.entity.ParentTask;
import com.fse.projectmanager.entity.Task;
import com.fse.projectmanager.repository.ParentTaskRepository;
import com.fse.projectmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ParentTaskRepository parentTaskRepository;

    public Task addTask(Task task) {
        return this.taskRepository.save(task);
    }

    public List<Task> viewTasks() {
        return this.taskRepository.findAll();
    }

    public ParentTask addParentTask(ParentTask newParentTask) {
        return this.parentTaskRepository.save(newParentTask);
    }

    public Task validateParentTask(String task) {
        return this.taskRepository.findTaskIdByTask(task);
    }

    public Integer getTaskCount(Integer projectId) {
        return this.taskRepository.getTaskCount(projectId);

    }

    public Integer getCompletedTasksCount(Integer projectId) {
        return this.taskRepository.getCompletedTasksCount(projectId);
    }
}
