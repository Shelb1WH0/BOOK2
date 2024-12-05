package com.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "genres")
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_номера")
    private Long id;

    @Column(name = "наименование", nullable = false, length = 50)
    private String name;
}
