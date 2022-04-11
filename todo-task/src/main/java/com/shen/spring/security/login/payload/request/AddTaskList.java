package com.shen.spring.security.login.payload.request;



import javax.validation.constraints.NotBlank;

public class AddTaskList {
	

	

	@NotBlank
	private String userName;

	@NotBlank
	private String task_desc;
	
	@NotBlank
	private int task_duration;
	

	public int getTask_duration() {
		return task_duration;
	}

	public void setTask_duration(int task_duration) {
		this.task_duration = task_duration;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}


	public String getTask_desc() {
		return task_desc;
	}

	public void setTask_desc(String task_desc) {
		this.task_desc = task_desc;
	}

	
	@Override
	public String toString() {
		return "AddTaskList [userName=" + userName + ", task_desc=" + task_desc + "]";
	}
}
