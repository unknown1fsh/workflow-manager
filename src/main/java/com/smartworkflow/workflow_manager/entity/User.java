package com.smartworkflow.workflow_manager.entity;

import com.smartworkflow.workflow_manager.base.BaseEntity;
import com.smartworkflow.workflow_manager.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User extends BaseEntity {

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Column(nullable = false)
    private Boolean active = true;
}
