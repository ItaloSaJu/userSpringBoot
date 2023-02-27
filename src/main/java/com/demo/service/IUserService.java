package com.demo.service;


import java.util.Optional;
import com.demo.entities.User;

public interface IUserService {

	public Iterable<User> findAll();
	public Optional<User> findById(Long id);
	public User save(User user);
	public void deleteById(Long id);
}
