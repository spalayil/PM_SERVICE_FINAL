package com.fse.projectmanager.repository;

import com.fse.projectmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    public Task findTaskIdByTask(String task);

    @Query("select count(Task_ID) as Task_ID from Task where Project_ID=:projectId ")
    public Integer getTaskCount(@Param("projectId") Integer projectId);

    @Query("select count(Task_ID) as Task_ID from Task where Active_Flag=0 and Project_ID=:projectId")
    public Integer getCompletedTasksCount(@Param("projectId") Integer projectId);
}
