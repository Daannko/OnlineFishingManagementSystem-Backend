package com.example.ofms.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "lakes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lake {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private double area; // in acres or km²
    @Column
    private double volume; // in acre-feet or million m³
    @Column
    private double maxDepth; // in feet or meters
    @Column
    private String waterQuality; // a string or enum indicating water quality (e.g. excellent, good, fair, poor)
    @OneToMany
    @JoinTable(
            name = "fishes_seen",
            joinColumns = @JoinColumn(name = "lake_id"),
            inverseJoinColumns = @JoinColumn(name = "catch_id"))
    private List<Catch> fishes = new ArrayList<>(); // an array of fish species names
    @Column
    private Double averageTemperature; // in Celsius or Fahrenheit
    @Column
    private Double phLevel; // pH level of the water


}
