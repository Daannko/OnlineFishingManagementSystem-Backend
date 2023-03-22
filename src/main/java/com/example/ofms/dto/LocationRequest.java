package com.example.ofms.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationRequest {
    final private Double lat,lng;
}
