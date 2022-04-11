package com.shen.spring.security.login.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.shen.spring.security.login.models.Task;

import com.shen.spring.security.login.payload.request.AddTaskList;
import com.shen.spring.security.login.payload.request.RemoveTask;
import com.shen.spring.security.login.payload.request.StatusRequest;
import com.shen.spring.security.login.payload.response.MessageResponse;
import com.shen.spring.security.login.payload.response.TaskDetails;
import com.shen.spring.security.login.payload.response.TaskListResponse;
import com.shen.spring.security.login.payload.response.UserInfoResponse;
import com.shen.spring.security.login.repository.TaskRepository;
import com.shen.spring.security.login.security.services.TaskService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test")
public class TestController {
	
@Autowired
	  TaskRepository taskRepository;

@Autowired
TaskService ts;


	
	


  @GetMapping("/user/{userName}")
  @PreAuthorize("hasRole('USER') ")
  public ResponseEntity<TaskListResponse> findAllTask(@PathVariable("userName") String userName) {
	  TaskDetails taskDetails; 
	  TaskListResponse taskListResp = new TaskListResponse();
	  List<Task> ts_list = ts.findTaskByUser(userName);
	  List<TaskDetails> task_details = new ArrayList<TaskDetails>();
	  taskListResp.setUsername(ts_list.get(0).getUserName());
	  
	  for(Task task:ts_list) {
		  taskDetails = new TaskDetails();
		  taskDetails.setTask_desc(task.getTask_desc());
		  taskDetails.setTask_duration(task.getTask_duration());
		  taskDetails.setDate(task.getdate());
		  taskDetails.setChecked_status(task.getChecked_status());
		  
		  task_details.add(taskDetails);
		  

	  }

	  taskListResp.setTaskList(task_details);

	  return ResponseEntity.ok().body(taskListResp);
  }
  
  @PutMapping("/user/status")
  @PreAuthorize("hasRole('USER') ")
  public ResponseEntity<?> checkedStatus(@RequestBody StatusRequest statusRequest)  {

	  
	  
	  boolean response = ts.update(statusRequest);
	  if(response) {
		  return ResponseEntity.ok(new MessageResponse("Task updated successfully!"));
	  }else {
		  return ResponseEntity.ok(new MessageResponse("Task updation failed!"));
	  }
  }
  
  @PostMapping("/user/addtask")
  @PreAuthorize("hasRole('USER') ")
  public ResponseEntity<?> createTask(@RequestBody AddTaskList addTaskList) throws SecurityException, IOException {
  	Task task = new Task();
  	task.setUserName(addTaskList.getuserName());
  	task.setTask_desc(addTaskList.getTask_desc());
  	task.setTask_duration(addTaskList.getTask_duration());
  	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
  	Date date=new Date(timestamp.getTime());
  	task.setdate(date);
  	task.setChecked_status(false);
  	taskRepository.save(task);
  	return ResponseEntity.ok(new MessageResponse("Task added successfully!"));
  }

  @PostMapping("/user/deletetask")
  @PreAuthorize("hasRole('USER') ")
  public ResponseEntity<?> deleteTask(@RequestBody RemoveTask removeTask) throws SecurityException, IOException {
  	
  	boolean response = ts.delete(removeTask.getTask_desc(), removeTask.getUserName());
  	if(response) {
  		return ResponseEntity.ok(new MessageResponse("Task deleted successfully!"));
  	}else {
  		return ResponseEntity.ok(new MessageResponse("Task deletion failed"));
  	}
  	
  }

  
  
}
