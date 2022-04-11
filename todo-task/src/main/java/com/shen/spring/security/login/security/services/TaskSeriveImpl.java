package com.shen.spring.security.login.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shen.spring.security.login.models.Task;
import com.shen.spring.security.login.payload.request.StatusRequest;
import com.shen.spring.security.login.repository.TaskRepository;

@Service
public class TaskSeriveImpl implements TaskService{
	
	@Autowired
	  TaskRepository taskRepository;

	
	@Override
	public List<Task> findTaskByUser(String userName) {
		List<Task> task_list = taskRepository.findByUserName(userName);
		return task_list;
	}

	@Override
	public Task save(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String task_desc,String userName) {
		boolean result = false;
		List<Task> task_list = taskRepository.findByUserName(userName);
		for(Task task:task_list) {
	
			if(task.getTask_desc().equals(task_desc)) {
				
				taskRepository.delete(task);
				result = true;
			}
		}
			
			
		return result;
	}

	@Override
	public boolean update(StatusRequest statusRequest) {
		boolean result = false;
		List<Task> task_list = taskRepository.findByUserName(statusRequest.getUserName());
		for(Task task:task_list) {
			if(task.getTask_desc().equals(statusRequest.getTask_desc())) {
				
				 task.setChecked_status(statusRequest.getChecked());
				 Long id = task.getId();
				 taskRepository.save(task);
				 Optional<Task> task1 = taskRepository.findById(id);
				 if(task1.get().getChecked_status() == statusRequest.getChecked())
					 result = true;
			}
		}
		return result;
	}
	
/*	@Override
	public boolean update(StatusRequest statusRequest) {
		List<Task> task_list = taskRepository.findByUserName(statusRequest.getUserName());
		for(Task task:task_list) {
			if(task.getTask_desc().equals(statusRequest.getTask_desc()) ){
				if(statusRequest.isChecked()) {
					task.setChecked_status(1);
					return true;
				}
			}
		}
		return false;
	}*/



}
