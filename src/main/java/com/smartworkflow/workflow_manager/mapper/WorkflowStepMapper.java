package com.smartworkflow.workflow_manager.mapper;

import com.smartworkflow.workflow_manager.dto.WorkflowStepDTO;
import com.smartworkflow.workflow_manager.entity.WorkflowStep;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WorkflowStepMapper {

    @Mapping(source = "assignedUser.id", target = "assignedUserId")
    @Mapping(source = "workflow.id", target = "workflowId")
    WorkflowStepDTO toDto(WorkflowStep step);

    @Mapping(source = "assignedUserId", target = "assignedUser.id")
    @Mapping(source = "workflowId", target = "workflow.id")
    WorkflowStep toEntity(WorkflowStepDTO dto);
}

