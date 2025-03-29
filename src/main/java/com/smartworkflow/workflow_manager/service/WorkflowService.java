package com.smartworkflow.workflow_manager.service;

import com.smartworkflow.workflow_manager.dto.WorkflowDTO;

import java.util.List;

public interface WorkflowService {

    WorkflowDTO getWorkflowById(Long id);

    List<WorkflowDTO> getAllWorkflows();

    WorkflowDTO createWorkflow(WorkflowDTO dto);

    WorkflowDTO updateWorkflow(Long id, WorkflowDTO dto);

    void deleteWorkflow(Long id);
}
