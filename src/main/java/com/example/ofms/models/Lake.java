package com.example.ofms.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


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
    private double area; // in acres or km²
    private double volume; // in acre-feet or million m³
    private double maxDepth; // in feet or meters
    private String waterQuality; // a string or enum indicating water quality (e.g. excellent, good, fair, poor)
    private Double averageTemperature; // in Celsius or Fahrenheit
    private Double phLevel;
    @Column(nullable = false)
    private Double lat,lng;// pH level of the water


}
