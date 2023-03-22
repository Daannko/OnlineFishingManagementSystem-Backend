package com.example.ofms.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "fishes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fish {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String species;
    @Column
    private double length;
    @Column
    private double weight;
    @Column
    private boolean taken;






}
