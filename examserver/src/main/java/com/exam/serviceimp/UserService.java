package com.exam.serviceimp;

import com.exam.model.UserEntity;
import com.exam.model.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // Creating user
    public UserEntity createUser(UserEntity user, Set<UserRole> userRoles) throws Exception {
        UserEntity local = this.userRepository.findByUserName(user.getUsername());
        if (local != null) {
            System.out.println("User is already there!!");
            throw new Exception("User already present");
        } else {
            // create user
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }

        return local;
    }

}