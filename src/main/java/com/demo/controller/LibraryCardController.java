package com.demo.controller;

import com.demo.model.LibraryCard;
import com.demo.repository.LibraryCardRepository;
import com.demo.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarycards")
public class LibraryCardController {

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    @Autowired
    private IssueRepository issueRepository;

    @PostMapping
    public LibraryCard createLibraryCard(@RequestBody LibraryCard libraryCard) {
        if (!issueRepository.existsById(libraryCard.getIssue().getId())) {
            throw new RuntimeException("Issue not found.");
        }
        return libraryCardRepository.save(libraryCard);
    }

    @GetMapping
    public List<LibraryCard> getAllLibraryCards() {
        return libraryCardRepository.findAll();
    }
}
