package com.shen.spring.security.login.payload.request;



import java.util.Date;

import javax.validation.constraints.NotBlank;

public class ListAllTask {
	
	
	private Long id;




	@NotBlank
	private String userName;

	@NotBlank
	private String task_desc;
	
	@NotBlank
	private int task_duration;
	
	private Date date;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTask_desc() {
		return task_desc;
	}

	public void setTask_desc(String task_desc) {
		this.task_desc = task_desc;
	}

	public int getTask_duration() {
		return task_duration;
	}


	public void setTask_duration(int task_duration) {
		this.task_duration = task_duration;
	}

	public Date getDate() {
		return date;
	}






	public void setDate(Date date) {
		this.date = date;
	}




	@Override
	public String toString() {
		return "ListAllTask [id=" + id + ", userName=" + userName + ", task_desc=" + task_desc + ", task_duration="
				+ task_duration + ", date=" + date + "]";
	}




	
	

	

	
	
}
