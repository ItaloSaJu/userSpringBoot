package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
	
	
}
