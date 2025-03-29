package com.smartworkflow.workflow_manager.service.impl;

import com.smartworkflow.workflow_manager.dto.WorkflowStepDTO;
import com.smartworkflow.workflow_manager.entity.WorkflowStep;
import com.smartworkflow.workflow_manager.mapper.WorkflowStepMapper;
import com.smartworkflow.workflow_manager.repository.WorkflowStepRepository;
import com.smartworkflow.workflow_manager.service.WorkflowStepService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowStepServiceImpl implements WorkflowStepService {

    private final WorkflowStepRepository workflowStepRepository;
    private final WorkflowStepMapper workflowStepMapper;

    @Override
    public WorkflowStepDTO getStepById(Long id) {
        WorkflowStep step = workflowStepRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Step bulunamadı: " + id));
        return workflowStepMapper.toDto(step);
    }

    public List<WorkflowStepDTO> getStepsByWorkflowId(Long workflowId) {
        return workflowStepRepository.findByWorkflow_IdOrderByStepOrder(workflowId)
                .stream()
                .map(workflowStepMapper::toDto)
                .toList();
    }

    @Override
    public WorkflowStepDTO createStep(WorkflowStepDTO dto) {
        WorkflowStep step = workflowStepMapper.toEntity(dto);
        return workflowStepMapper.toDto(workflowStepRepository.save(step));
    }

    @Override
    public WorkflowStepDTO updateStep(Long id, WorkflowStepDTO dto) {
        WorkflowStep step = workflowStepRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Step bulunamadı: " + id));

        step.setStepOrder(dto.getStepOrder());
        step.setStepName(dto.getStepName());
        step.setStatus(dto.getStatus());

        return workflowStepMapper.toDto(workflowStepRepository.save(step));
    }

    @Override
    public void deleteStep(Long id) {
        workflowStepRepository.deleteById(id);
    }
}
