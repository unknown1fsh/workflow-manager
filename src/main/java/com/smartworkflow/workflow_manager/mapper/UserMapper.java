package com.smartworkflow.workflow_manager.mapper;

import com.smartworkflow.workflow_manager.dto.UserDTO;
import com.smartworkflow.workflow_manager.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User toEntity(UserDTO userDTO);

    @Mapping(target = "password", ignore = true)
    UserDTO toDto(User user);
}
