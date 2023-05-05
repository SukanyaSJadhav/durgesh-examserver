package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	
	public UserEntity findByUserName(String username);
}
