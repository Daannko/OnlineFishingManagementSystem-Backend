package com.ofms.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "lakes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lake {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    private double area;
    private double volume;
    private double maxDepth;
    private String waterQuality;
    private Double averageTemperature;
    private Double phLevel;
    private Double lat,lng;


}
