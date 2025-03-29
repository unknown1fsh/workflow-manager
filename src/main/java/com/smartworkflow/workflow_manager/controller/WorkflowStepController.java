package com.smartworkflow.workflow_manager.controller;

import com.smartworkflow.workflow_manager.dto.WorkflowStepDTO;
import com.smartworkflow.workflow_manager.service.WorkflowStepService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
@RequiredArgsConstructor
public class WorkflowStepController {

    private final WorkflowStepService stepService;

    @GetMapping("/{id}")
    public ResponseEntity<WorkflowStepDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(stepService.getStepById(id));
    }

    @GetMapping("/workflow/{workflowId}")
    public ResponseEntity<List<WorkflowStepDTO>> getByWorkflow(@PathVariable Long workflowId) {
        return ResponseEntity.ok(stepService.getStepsByWorkflowId(workflowId));
    }

    @PostMapping
    public ResponseEntity<WorkflowStepDTO> create(@RequestBody WorkflowStepDTO dto) {
        return ResponseEntity.ok(stepService.createStep(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkflowStepDTO> update(@PathVariable Long id, @RequestBody WorkflowStepDTO dto) {
        return ResponseEntity.ok(stepService.updateStep(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stepService.deleteStep(id);
        return ResponseEntity.noContent().build();
    }
}
