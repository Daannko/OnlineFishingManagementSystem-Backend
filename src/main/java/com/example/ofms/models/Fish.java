package com.example.ofms.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity(name = "fishes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fish {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Long userId;
    private String species;
    private double length;
    private double weight;
    private boolean taken;
    @ManyToOne
    @JoinColumn(name = "catch_id")
    private Catch aCatch;





}
