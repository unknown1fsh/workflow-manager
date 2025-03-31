package com.smartworkflow.workflow_manager.mapper;

import com.smartworkflow.workflow_manager.dto.WorkflowDTO;
import com.smartworkflow.workflow_manager.entity.Workflow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {WorkflowStepMapper.class})
public interface WorkflowMapper {

    @Mapping(source = "createdBy.id", target = "createdById")
    @Mapping(source = "createdBy.username", target = "createdByName")
    @Mapping(source = "steps", target = "steps")
    WorkflowDTO toDto(Workflow workflow);

    @Mapping(source = "createdById", target = "createdBy.id")
    @Mapping(source = "steps", target = "steps")
    Workflow toEntity(WorkflowDTO workflowDTO);
}

