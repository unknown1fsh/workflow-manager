package com.smartworkflow.workflow_manager.controller;

import com.smartworkflow.workflow_manager.dto.WorkflowDTO;
import com.smartworkflow.workflow_manager.service.WorkflowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workflows")
@RequiredArgsConstructor
public class WorkflowController {

    private final WorkflowService workflowService;

    @GetMapping("/{id}")
    public ResponseEntity<WorkflowDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(workflowService.getWorkflowById(id));
    }

    @GetMapping
    public ResponseEntity<List<WorkflowDTO>> getAll() {
        return ResponseEntity.ok(workflowService.getAllWorkflows());
    }

    @PostMapping
    public ResponseEntity<WorkflowDTO> create(@RequestBody WorkflowDTO dto) {
        return ResponseEntity.ok(workflowService.createWorkflow(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkflowDTO> update(@PathVariable Long id, @RequestBody WorkflowDTO dto) {
        return ResponseEntity.ok(workflowService.updateWorkflow(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        workflowService.deleteWorkflow(id);
        return ResponseEntity.noContent().build();
    }
}
