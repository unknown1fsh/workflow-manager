package com.smartworkflow.workflow_manager.dto;

import com.smartworkflow.workflow_manager.enums.StepStatus;
import lombok.Data;

@Data
public class WorkflowStepDTO {
    private Long id;
    private Integer stepOrder;
    private String stepName;
    private Long assignedUserId;
    private StepStatus status;
    private Long workflowId;
}
