package com.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "statuses")
@Data
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_статуса")
    private Long id;

    @Column(name = "наименование", nullable = false, length = 50)
    private String name;
}
