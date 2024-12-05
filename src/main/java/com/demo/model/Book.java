package com.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_книги")
    private Long id;

    @Column(name = "название", nullable = false, length = 200)
    private String title;

    @Column(name = "издание", length = 100)
    private String publisher;

    @ManyToOne
    @JoinColumn(name = "id_автора", nullable = false) // Связь с автором
    private Author author;

    @ManyToOne
    @JoinColumn(name = "id_статуса", nullable = false) // Связь со статусом
    private Status status;

    // Геттеры и сеттеры (для примера)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
