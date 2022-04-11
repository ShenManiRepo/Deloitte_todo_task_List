package com.shen.spring.security.login.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "users_roles")
public class UserRoles {
	
	
	@Id
	long user_id;

	
	int roles_id;
	
	
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public int getRoles_id() {
		return roles_id;
	}
	public void setRoles_id(int roles_id) {
		this.roles_id = roles_id;
	}
	
	


	@Override
	public String toString() {
		return "UserRoles [user_id=" + user_id + ", role_id=" + roles_id + "]";
	}
}
