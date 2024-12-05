package com.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_клиента")
    private Long id;

    @Column(name = "фио", nullable = false, length = 100)
    private String fullName;

    @Column(name = "возраст", nullable = false)
    private int age;
}
