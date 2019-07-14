package com.fse.projectmanager.entity;

import javax.persistence.*;

@Entity
@Table(name="Parent_Task")
public class ParentTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Parent_ID", nullable = false)
    Integer parentId;

    @Column(name = "Parent_Task")
    String parentTask;

    public ParentTask() {
    }

    public ParentTask(Integer parentId, String parentTask) {
        this.parentId = parentId;
        this.parentTask = parentTask;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }
}
