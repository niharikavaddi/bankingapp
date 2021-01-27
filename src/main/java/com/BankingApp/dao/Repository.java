package com.BankingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingApp.model.User;

public interface Repository extends JpaRepository<User, Integer> {

}
