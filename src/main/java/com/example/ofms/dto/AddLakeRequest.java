package com.example.ofms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddLakeRequest {
    private String name;
    private double area; // in acres or km²
    private double volume; // in acre-feet or million m³
    private double maxDepth; // in feet or meters
    private String waterQuality; // a string or enum indicating water quality (e.g. excellent, good, fair, poor)
    private Double averageTemperature; // in Celsius or Fahrenheit
    private Double phLevel;
    private Double lat,lng;// pH level of the water
}
