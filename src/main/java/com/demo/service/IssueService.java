package com.demo.service;

import com.demo.model.Issue;
import com.demo.repository.IssueRepository;
import com.demo.repository.BookRepository;
import com.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ClientRepository clientRepository;
    public Issue createIssue(Issue issue) {
        if (!bookRepository.existsById(issue.getBook().getId())) {
            throw new RuntimeException("Book not found.");
        }
        if (!clientRepository.existsById(issue.getClient().getId())) {
            throw new RuntimeException("Client not found.");
        }
        return issueRepository.save(issue);
    }
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }
    public void deleteIssue(Long id) {
        if (!issueRepository.existsById(id)) {
            throw new RuntimeException("Issue not found");
        }
        issueRepository.deleteById(id);
    }
}
