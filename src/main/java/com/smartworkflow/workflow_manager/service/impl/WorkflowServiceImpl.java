package com.smartworkflow.workflow_manager.service.impl;

import com.smartworkflow.workflow_manager.dto.WorkflowDTO;
import com.smartworkflow.workflow_manager.entity.Workflow;
import com.smartworkflow.workflow_manager.mapper.WorkflowMapper;
import com.smartworkflow.workflow_manager.repository.WorkflowRepository;
import com.smartworkflow.workflow_manager.service.WorkflowService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowServiceImpl implements WorkflowService {

    private final WorkflowRepository workflowRepository;
    private final WorkflowMapper workflowMapper;

    @Override
    public WorkflowDTO getWorkflowById(Long id) {
        Workflow workflow = workflowRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Workflow bulunamadı: " + id));
        return workflowMapper.toDto(workflow);
    }

    @Override
    public List<WorkflowDTO> getAllWorkflows() {
        return workflowRepository.findAll()
                .stream()
                .map(workflowMapper::toDto)
                .toList();
    }

    @Override
    public WorkflowDTO createWorkflow(WorkflowDTO dto) {
        Workflow entity = workflowMapper.toEntity(dto);
        return workflowMapper.toDto(workflowRepository.save(entity));
    }

    @Override
    public WorkflowDTO updateWorkflow(Long id, WorkflowDTO dto) {
        Workflow workflow = workflowRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Workflow bulunamadı: " + id));

        workflow.setName(dto.getName());
        workflow.setDescription(dto.getDescription());

        return workflowMapper.toDto(workflowRepository.save(workflow));
    }

    @Override
    public void deleteWorkflow(Long id) {
        workflowRepository.deleteById(id);
    }
}
