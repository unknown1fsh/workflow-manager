package com.smartworkflow.workflow_manager.dto;

import lombok.Data;

import java.util.List;

@Data
public class WorkflowDTO {
    private Long id;
    private String name;
    private String description;
    private Long createdById;
    private List<WorkflowStepDTO> steps;
}
