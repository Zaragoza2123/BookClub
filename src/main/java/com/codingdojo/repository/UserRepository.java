package com.codingdojo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
	public User findByEmail(String email);
    
}
