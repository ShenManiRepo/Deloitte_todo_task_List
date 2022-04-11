package com.shen.spring.security.login.payload.response;

import java.util.Date;

public class TaskDetails {
	String task_desc;

	int task_duration;
	Date date;
	
	boolean checked_status;
	
	
	public void setChecked_status(boolean checked_status) {
		this.checked_status = checked_status;
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
	public String getTask_desc() {
		return task_desc;
	}
	public boolean getChecked_status() {
		return checked_status;
	}
	@Override
	public String toString() {
		return "TaskDetails [task_desc=" + task_desc + ", task_duration=" + task_duration + ", date=" + date + "]";
	}

}
