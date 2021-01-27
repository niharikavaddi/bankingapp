package com.BankingApp.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.BankingApp.model.User;
import com.BankingApp.service.Service;

@CrossOrigin(value = "http://locahost:4200")
@RestController
@RequestMapping("/users")
public class Controller {

	@Autowired
	Service service;

	@PostMapping(value = "/create")
	public User createUser(@RequestBody User user) throws SQLIntegrityConstraintViolationException {
		return service.createUser(user);
	}

	@PostMapping(value = "/authenticate")
	public User authenticateUser(@RequestBody User user) throws NoSuchElementException {
		return service.authenticateUser(user);
	}

	@GetMapping(value = "/approve/{userId}")
	public User approveUser(@PathVariable("userId") int userId) {
		return service.approveUser(userId);
	}

	@GetMapping(value = "/findbyid/{userId}")
	public User getUserById(@PathVariable("userId") int userId) {
		return service.getUserById(userId);
	}

	@GetMapping(value = "/reject/{userId}")
	public User rejectUser(@PathVariable("userId") int userId) {
		return service.rejectUser(userId);
	}

	@GetMapping(value = "/getusers")
	public List<User> getApprovedAndNewUsers() {
		return service.getApprovedAndNewUsers();
	}

	@GetMapping(value = "/getallusers")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

}
