package com.demo.controller;

import com.demo.model.Issue;
import com.demo.repository.IssueRepository;
import com.demo.repository.BookRepository;
import com.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public Issue createIssue(@RequestBody Issue issue) {
        if (!bookRepository.existsById(issue.getBook().getId())) {
            throw new RuntimeException("Book not found.");
        }
        if (!clientRepository.existsById(issue.getClient().getId())) {
            throw new RuntimeException("Client not found.");
        }
        return issueRepository.save(issue);
    }

    @GetMapping
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }
}
