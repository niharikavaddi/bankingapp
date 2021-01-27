package com.BankingApp.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.BankingApp.dao.Repository;
import com.BankingApp.model.User;

@org.springframework.stereotype.Service("service")
public class ServiceImpl implements Service {

	@Autowired
	Repository repository;

	@Override
	public User createUser(User user) throws SQLIntegrityConstraintViolationException {
		user.setApprovalStatus("new");
		user.setRole("user");
		return repository.save(user);
	}

	@Override
	public User authenticateUser(User user) throws NoSuchElementException {

		List<User> users = repository.findAll();
		/*
		 * return users.stream() .filter(check ->
		 * check.getUserName().equals(user.getUserName())) .filter(check ->
		 * check.getUserPassword().equals(user.getUserPassword())) .findFirst()
		 * .orElseThrow(() -> new NoSuchElementException());
		 */
		return users.stream().filter(check -> check.getUserName().equals(user.getUserName()))
				.filter(check -> check.getUserPassword().equals(user.getUserPassword())).findFirst().get();

	}

	@Override
	public User approveUser(int userId) {
		User user = repository.findById(userId).get();
		user.setApprovalStatus("approved");
		return repository.save(user);
	}

	@Override
	public User rejectUser(int userId) {
		User user = repository.findById(userId).get();
		user.setApprovalStatus("denied");
		return repository.save(user);
	}

	@Override
	public User getUserById(int userId) throws NoSuchElementException {
		Optional<User> user = repository.findById(userId);
		if (user.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return user.get();
		}
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public List<User> getApprovedAndNewUsers() {
		return repository.findAll().stream().filter(
				check -> check.getApprovalStatus().equals("new") || check.getApprovalStatus().equals("approved"))
				.collect(Collectors.toList());
	}

}
