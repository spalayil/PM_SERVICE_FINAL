package com.fse.projectmanager.model;

public class UserModel {

    private Integer userID;
    private String firstName;
    private String lastName;
    private Integer employeeID;
    private Integer projectID;
    private Integer taskID;

    public UserModel() {
    }

    public UserModel(Integer userID, String firstName, String lastName, Integer employeeID, Integer projectID,
                     Integer taskID) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.projectID = projectID;
        this.taskID = taskID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public Integer getTaskID() {
        return taskID;
    }

    public void setTaskID(Integer taskID) {
        this.taskID = taskID;
    }
}
