package com.shen.spring.security.login.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.shen.spring.security.login.models.Task;



@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	List<Task> findByUserName(String userName);
	
	//Task findByTask_desc(String task_desc);
}
