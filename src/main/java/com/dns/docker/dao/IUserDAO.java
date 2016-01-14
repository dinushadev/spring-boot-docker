package com.dns.docker.dao;

import org.springframework.data.repository.CrudRepository;

import com.dns.docker.entity.User;

public interface IUserDAO extends CrudRepository<User, Long>{

	
	public User findByEmail(String email);
}
