package com.example.ofms.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "catches")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Catch {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "cought_fishes",
            joinColumns = @JoinColumn(name = "catch_id"),
            inverseJoinColumns = @JoinColumn(name = "fish_id"))
    private List<Fish> fish;// in inches or centimeters
    private Date dateTime;
    private String location;
    private String bait;


}
