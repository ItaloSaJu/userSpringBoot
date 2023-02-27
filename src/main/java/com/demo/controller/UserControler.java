package com.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.User;
import com.demo.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserControler {

	@Autowired
	private IUserService iUserService;
	
	//create new user
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(iUserService.save(user));
	}
	
	//read an user
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		 Optional<User> oUser = iUserService.findById(id);
		 if(!oUser.isPresent()) {
			 return ResponseEntity.notFound().build();
		 }
		 return ResponseEntity.ok(oUser);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id){
		Optional<User> users = iUserService.findById(id);
		if(!users.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		users.get().setName(user.getName());
		users.get().setSurname(user.getSurname());
		users.get().setEmail(user.getEmail());
		users.get().setEnabled(user.getEnabled());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(iUserService.save(users.get()));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") Long userId){
		if(!iUserService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		iUserService.deleteById(userId);
		return ResponseEntity.ok().build ();
	}
	 
	@GetMapping
	public List<User> readAll(){
		List<User> users = StreamSupport
				.stream(iUserService.findAll().spliterator(),false)
				.collect(Collectors.toList());
		return users;
	}
	
	
	
}
