package com.example.ofms.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Long id;
    private Long userId;
    private Long lakeId;
    private Date dateTime;
    @OneToMany(
            mappedBy = "aCatch",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Fish> fishes = new ArrayList<>();

}
