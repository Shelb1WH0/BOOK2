package com.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "issues")
@Data
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_выдачи")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_книги", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "id_клиента", nullable = false)
    private Client client;
}
