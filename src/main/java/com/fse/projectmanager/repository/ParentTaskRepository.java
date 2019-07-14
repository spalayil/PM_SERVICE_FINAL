package com.fse.projectmanager.repository;

import com.fse.projectmanager.entity.ParentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentTaskRepository extends JpaRepository<ParentTask, Long> {

    public Integer findByParentTask(String parentTask);
}
