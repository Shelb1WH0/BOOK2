package com.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "library_cards")
@Data
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_билета")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_выдачи", nullable = false)
    private Issue issue;
}
