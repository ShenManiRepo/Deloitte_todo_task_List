package com.shen.spring.security.login.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotBlank
	@Size(max = 20)
	
	String userName;
	
	@NotBlank
	String task_desc;
	
	int task_duration;
	
	boolean checked_status;
	

	@Temporal(TemporalType.TIMESTAMP)
	Date date;
	
	public Task() {
		
	}
	
	public Task(String userName, String task_desc, Date date) {
		
		this.userName = userName;
		this.task_desc = task_desc;
		this.date = date;
	}
	
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
	public Date getdate() {
		return date;
	}
	public void setdate(Date date) {
		this.date = date;
	}
	public boolean getChecked_status() {
		return checked_status;
	}

	public void setChecked_status(boolean b) {
		this.checked_status = b;
	}
}
