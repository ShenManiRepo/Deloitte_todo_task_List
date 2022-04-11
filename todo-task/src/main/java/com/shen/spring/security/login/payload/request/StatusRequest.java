package com.shen.spring.security.login.payload.request;

import javax.validation.constraints.NotBlank;

public class StatusRequest {
	@NotBlank
	private String userName;


	@NotBlank
	private String task_desc;
	
	private boolean checked;
	
	
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

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	
}
