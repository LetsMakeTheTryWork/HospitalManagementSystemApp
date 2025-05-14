package com.abby.hms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedule_slots")
public class ScheduleSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private LocalDateTime slotTime;

    @Column(nullable = false)
    private boolean isAvailable;

    // Getters and setters
}
