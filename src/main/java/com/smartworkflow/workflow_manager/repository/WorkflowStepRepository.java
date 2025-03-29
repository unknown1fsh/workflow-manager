package com.smartworkflow.workflow_manager.repository;

import com.smartworkflow.workflow_manager.entity.WorkflowStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkflowStepRepository extends JpaRepository<WorkflowStep, Long> {
    List<WorkflowStep> findByWorkflow_IdOrderByStepOrder(Long workflowId);
}
