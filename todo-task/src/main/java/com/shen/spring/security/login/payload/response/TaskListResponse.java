package com.shen.spring.security.login.payload.response;


import java.util.List;



public class TaskListResponse {


	private String username;

	private List<TaskDetails> taskList;
	 
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<TaskDetails> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TaskDetails> taskList) {
		this.taskList = taskList;
	}

	@Override
	public String toString() {
		return "TaskListResponse [username=" + username + ", taskList=" + taskList + "]";
	}

	
}
