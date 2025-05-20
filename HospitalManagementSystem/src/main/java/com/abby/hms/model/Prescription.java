package com.abby.hms.model;

import jakarta.persistence.*;
@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private String medicine;

    @Column(nullable = false)
    private String dosage;

    // Getters and setters
}
