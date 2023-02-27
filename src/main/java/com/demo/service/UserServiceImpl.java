package com.demo.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.User;
import com.demo.repo.IUserRepo;

@Transactional
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo userRepo;
	
	
	
	public UserServiceImpl(IUserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public Iterable<User> findAll() {
		
		return userRepo.findAll();
	}

	

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public void deleteById(Long id) {
		userRepo.deleteById(id);

	}

}
