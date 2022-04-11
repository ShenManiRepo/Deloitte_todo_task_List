package com.shen.spring.security.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shen.spring.security.login.models.Task;
import com.shen.spring.security.login.models.UserRoles;

@Repository
public interface User_RolesRepository extends JpaRepository<UserRoles, String>{

}
