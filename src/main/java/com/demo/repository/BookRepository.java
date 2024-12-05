package com.demo.repository;

import com.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Пример дополнительного метода для поиска книг по автору
   // List<Book> findByAuthorId(Long authorId);

    // Пример метода для поиска книг по статусу
   // List<Book> findByStatusId(Long statusId);
}
