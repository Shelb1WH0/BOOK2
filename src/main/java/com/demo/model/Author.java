package com.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "authors")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_автора")
    private Long id;

    @Column(name = "фио", nullable = false, length = 100)
    private String fullName;
}
