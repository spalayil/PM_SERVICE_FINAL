package com.fse.projectmanager.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fse.projectmanager.entity.ParentTask;
import com.fse.projectmanager.entity.Project;
import com.fse.projectmanager.entity.Task;
import com.fse.projectmanager.entity.User;
import com.fse.projectmanager.model.ProjectModel;
import com.fse.projectmanager.model.TaskModel;
import com.fse.projectmanager.model.UserModel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
	
    public static String serializeObjectAsJsonString(Object object) throws IOException{
    	ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(object);
    }
    
    public static User getUser() {
    	User user = new User(1, "sreejith", "palayil", 123456,
				null, null);
    	return user;
    }
    
    public static UserModel getUserModel() {
    	UserModel user = new UserModel(1, "sreejith", "palayil", 123456,
				null, null);
    	return user;
    }
    
    public static List<User> getUserList() {

		List<User> userList = new ArrayList<User>();

		userList.add(new User(1, "sreejith", "palayil", 123456,
				null, null));

		userList.add(new User(2, "advay", "sreejith", 123456,
				null, null));

		return userList;
	}
    
	public static Project getProject() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		Project project=null;
		try {
			project = new Project(1, "Test Project1", "Manoj",
					sdf.parse("07-20-2019"), sdf.parse("087-25-2019"), 3, true);
		} catch (ParseException e) {
		}
		
		return project;

	}
	
	 public static List<Project> getProjectList() {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			List<Project> userList = new ArrayList<Project>();

			try {
				userList.add(new Project(1, "Test Project1", "Manoj",
						sdf.parse("07-20-2019"), sdf.parse("087-25-2019"), 3, true));
			

			userList.add(new Project(2, "Test Project1", "John",
					sdf.parse("06-25-2019"), sdf.parse("06-25-2019"), 8, true));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userList;
		}
	public static ProjectModel getProjectModel() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		ProjectModel project=null;
		try {
			project = new ProjectModel(1, "Test Project1", "Manoj", 3,
					sdf.parse("07-20-2019"), sdf.parse("087-25-2019"),  true,
					null, null);
		} catch (ParseException e) {
		}
		
		return project;

	}
	
	public static Task getTask() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		Task task=null;
		try {
			task = new Task(1, 2, 3, 4,
					"task", sdf.parse("06-25-2019"), sdf.parse("06-25-2019"), 1,
					null, null, true);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return task;
	}
	
	public static ParentTask getParentTask() {
		ParentTask task=null;
			task = new ParentTask(1,"task2");
		return task;
	}

	public static TaskModel getTaskModel() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		TaskModel taskModel=null;
		try {
			taskModel = new TaskModel(1, 2, "task", "parentTask",
					sdf.parse("06-25-2019"), sdf.parse("06-25-2019"),
					1, true, 3, 123, null);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskModel;
	}

	public static List<Task> getTaskList() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		List<Task> taskList = new ArrayList<Task>();

		try {
			taskList.add(new Task(1, 2, 3, 4,
					"task", sdf.parse("06-25-2019"), sdf.parse("06-25-2019"), 1,
					null, null, true));
		

			taskList.add(new Task(3, 4, 5, 5,
					"task2", sdf.parse("06-25-2019"), sdf.parse("06-25-2019"), 1,
					null, null, true));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskList;
	}
    
    
  
}
