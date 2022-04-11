package com.shen.spring.security.login.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shen.spring.security.login.models.Task;
import com.shen.spring.security.login.payload.request.StatusRequest;

@Service
public interface TaskService {
	List<Task> findTaskByUser(String username);

	Task save(Task task);

	

    boolean delete(String userName,String taskName);

	boolean update(StatusRequest statusRequest);
}
