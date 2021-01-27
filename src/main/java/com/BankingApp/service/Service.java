package com.BankingApp.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
import com.BankingApp.model.User;

public interface Service {

	public List<User> getAllUsers();

	public User createUser(User user) throws SQLIntegrityConstraintViolationException;

	public User authenticateUser(User user) throws NoSuchElementException;

	public User approveUser(int userId);

	public User rejectUser(int userId);

	public User getUserById(int userId) throws NoSuchElementException;

	public List<User> getApprovedAndNewUsers();

}
