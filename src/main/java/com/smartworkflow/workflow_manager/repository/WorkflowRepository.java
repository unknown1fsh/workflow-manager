package com.smartworkflow.workflow_manager.repository;

import com.smartworkflow.workflow_manager.entity.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
}
