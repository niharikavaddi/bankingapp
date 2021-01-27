package com.BankingApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME", length = 20, unique = true)
	private String userName;

	@Column(name = "USER_PASSWORD", length = 20)
	private String userPassword;

	@Column(name = "ROLE", length = 10)
	private String role;

	@Column(name = "USER_FIRSTNAME", length = 20)
	private String userFirstName;

	@Column(name = "USER_LASTNAME", length = 20)
	private String userLastName;

	@Column(name = "USER_AGE")
	private int userAge;

	@Column(name = "APPROVAL_STATUS", length = 10)
	private String approvalStatus;

}
