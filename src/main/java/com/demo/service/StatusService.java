package com.demo.service;

import com.demo.model.Status;
import com.demo.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;
    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }
    public Status getStatusById(Long id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found"));
    }
    public Status updateStatus(Long id, Status updatedStatus) {
        Status status = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found"));
        status.setName(updatedStatus.getName());
        return statusRepository.save(status);
    }
    public void deleteStatus(Long id) {
        if (!statusRepository.existsById(id)) {
            throw new RuntimeException("Status not found");
        }
        statusRepository.deleteById(id);
    }
}
