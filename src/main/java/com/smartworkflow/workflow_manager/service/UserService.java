package com.smartworkflow.workflow_manager.service;

import com.smartworkflow.workflow_manager.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
}
