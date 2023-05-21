package com.ofms.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long userId;
    private Long lakeId;
    private Date dateTime;
    @JsonManagedReference
    @OneToMany(
            mappedBy = "aCatch",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Fish> fishes = new ArrayList<>();

}
