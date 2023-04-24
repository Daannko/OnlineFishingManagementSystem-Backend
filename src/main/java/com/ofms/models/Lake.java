package com.ofms.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Long id;
    @Column(nullable = false)
    private String name;
    private double area;
    private double volume;
    private double maxDepth;
    private String waterQuality;
    private Double averageTemperature;
    private Double phLevel;
    @Column(nullable = false)
    private Double lat,lng;


}
