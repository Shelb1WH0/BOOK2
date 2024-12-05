package com.demo.service;

import com.demo.model.LibraryCard;
import com.demo.repository.LibraryCardRepository;
import com.demo.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;  // Добавьте импорт
@Service
public class LibraryCardService {
    @Autowired
    private LibraryCardRepository libraryCardRepository;
    @Autowired
    private IssueRepository issueRepository;
    public LibraryCard createLibraryCard(LibraryCard libraryCard) {
        if (!issueRepository.existsById(libraryCard.getIssue().getId())) {
            throw new RuntimeException("Issue not found.");
        }
        return libraryCardRepository.save(libraryCard);
    }
    public List<LibraryCard> getAllLibraryCards() {
        return libraryCardRepository.findAll();
    }
    public void deleteLibraryCard(Long id) {
        if (!libraryCardRepository.existsById(id)) {
            throw new RuntimeException("LibraryCard not found");
        }
        libraryCardRepository.deleteById(id);
    }
}
