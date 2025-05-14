package com.abby.hms.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medical_reports")
public class MedicalReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private String reportDetails;

    @Column(nullable = false)
    private LocalDate reportDate;

    // Getters and setters
}
