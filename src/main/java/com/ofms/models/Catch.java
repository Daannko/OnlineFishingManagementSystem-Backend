package com.ofms.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Date dateTime;
    @JsonManagedReference
    @OneToMany(
            mappedBy = "aCatch",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Fish> fishes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLakeId() {
        return lakeId;
    }

    public void setLakeId(Long lakeId) {
        this.lakeId = lakeId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public List<Fish> getFishes() {
        return fishes;
    }

    public void setFishes(List<Fish> fishes) {
        this.fishes = fishes;
    }
}
