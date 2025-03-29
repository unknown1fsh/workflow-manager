package com.smartworkflow.workflow_manager.dto;

import com.smartworkflow.workflow_manager.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private UserRole role;
    private Boolean active;
}
