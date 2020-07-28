package com.feedback.Demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.feedback.Demo.Entity.Users;

public interface UserRepository extends CrudRepository<Users, String>{

}
