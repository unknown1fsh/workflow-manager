package com.smartworkflow.workflow_manager.entity;

import com.smartworkflow.workflow_manager.base.BaseEntity;
import com.smartworkflow.workflow_manager.enums.StepStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "workflow_step")
public class WorkflowStep extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_id", nullable = false)
    private Workflow workflow;

    @Column(name = "step_order")
    private Integer stepOrder;

    @Column(name = "step_name", nullable = false, length = 100)
    private String stepName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StepStatus status = StepStatus.PENDING;
}
