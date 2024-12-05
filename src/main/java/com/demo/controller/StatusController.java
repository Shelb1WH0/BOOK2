package com.demo.controller;

import com.demo.model.Status;
import com.demo.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    @PostMapping
    public Status createStatus(@RequestBody Status status) {
        return statusRepository.save(status);
    }

    @GetMapping("/{id}")
    public Status getStatusById(@PathVariable Long id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found"));
    }

    @PutMapping("/{id}")
    public Status updateStatus(@PathVariable Long id, @RequestBody Status updatedStatus) {
        Status status = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found"));
        status.setName(updatedStatus.getName());
        return statusRepository.save(status);
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id) {
        statusRepository.deleteById(id);
    }
}

