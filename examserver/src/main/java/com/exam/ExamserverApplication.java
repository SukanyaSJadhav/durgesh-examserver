package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.model.Role;
import com.exam.model.UserEntity;
import com.exam.model.UserRole;
import com.exam.serviceimp.UserService;

import lombok.Builder;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("in command line runner");

		UserEntity userEntity = new UserEntity();

		userEntity.setFirstName("Devendra");
		userEntity.setLastName("Sanghavi");
		userEntity.setUsername("dev799");
		userEntity.setPassword("123456789");
		userEntity.setEmail("devendra@gmail.com");
		userEntity.setPhone("9049052815");

		Role role1 = new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");

		Set<UserRole> userRoleset = new HashSet<>();
		UserRole userRole = new UserRole();

		userRole.setRole(role1);
		userRole.setUserEntity(userEntity);

		userRoleset.add(userRole);

		UserEntity user1 = this.userService.createUser(userEntity, userRoleset);
		System.out.println(user1.getUsername());
	}

}
