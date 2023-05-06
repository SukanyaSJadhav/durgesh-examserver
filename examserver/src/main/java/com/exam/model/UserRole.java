package com.exam.model;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity userEntity;

    @ManyToOne
    private Role role;

    public UserRole(Long userRoleId, UserEntity userEntity, Role role) {
        super();
        this.userRoleId = userRoleId;
        this.userEntity = userEntity;
        this.role = role;
    }

    public UserRole() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
