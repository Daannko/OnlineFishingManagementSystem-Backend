package com.ofms.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long userId;
    private String species;
    private double length;
    private double weight;
    private boolean taken;
    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Catch aCatch;





}
