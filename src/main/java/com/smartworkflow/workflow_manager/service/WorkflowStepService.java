package com.smartworkflow.workflow_manager.service;

import com.smartworkflow.workflow_manager.dto.WorkflowStepDTO;

import java.util.List;

public interface WorkflowStepService {

    List<WorkflowStepDTO> getAllSteps();

    WorkflowStepDTO getStepById(Long id);

    List<WorkflowStepDTO> getStepsByWorkflowId(Long workflowId);

    WorkflowStepDTO createStep(WorkflowStepDTO dto);

    WorkflowStepDTO updateStep(Long id, WorkflowStepDTO dto);

    void deleteStep(Long id);
}
