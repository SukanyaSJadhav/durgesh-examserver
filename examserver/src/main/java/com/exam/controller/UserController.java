package com.exam.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Role;
import com.exam.model.UserEntity;
import com.exam.model.UserRole;
import com.exam.serviceimp.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

	@Autowired
	UserService userService;

	// create user
	@PostMapping(value = "/user")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) throws Exception {
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("Normal");
		UserRole userRole = new UserRole();
		userRole.setUserEntity(user);
		userRole.setRole(role);
		roles.add(userRole);

		UserEntity saved = this.userService.createUser(user, roles);
		return ResponseEntity.ok(saved);
	}

	@GetMapping(value = "/user/{username}")
	public ResponseEntity<UserEntity> getUser(@PathVariable("username") String username) {
		UserEntity user = this.userService.getUserByUserName(username);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping(value = "/delete/{userId}")
	public ResponseEntity<Optional<UserEntity>> deleteUser(@PathVariable("userId") Long userId) {
		Optional<UserEntity> userdeleted = this.userService.deleteUser(userId);
		return ResponseEntity.ok(userdeleted);
	}
}
