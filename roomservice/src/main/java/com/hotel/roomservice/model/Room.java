package com.hotel.roomservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;  // Example: Single, Double, Suite

    @Column(nullable = false)
    private int capacity; // Number of guests allowed

    @Column(nullable = false)
    private double price; // Per night charge

    @Column(nullable = false)
    private boolean available; // Availability status
}
