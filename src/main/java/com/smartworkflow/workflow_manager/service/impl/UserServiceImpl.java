package com.smartworkflow.workflow_manager.service.impl;

import com.smartworkflow.workflow_manager.dto.UserDTO;
import com.smartworkflow.workflow_manager.entity.User;
import com.smartworkflow.workflow_manager.mapper.UserMapper;
import com.smartworkflow.workflow_manager.repository.UserRepository;
import com.smartworkflow.workflow_manager.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    //private final BCryptPasswordEncoder passwordEncoder;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı: " + id));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı: " + id));

        user.setUsername(userDTO.getUsername());
        user.setRole(userDTO.getRole());
        user.setActive(userDTO.getActive());
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
