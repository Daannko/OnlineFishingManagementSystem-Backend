package com.ofms.controllers;

import com.ofms.AOP.DataAspect;
import com.ofms.AOP.DataStatistics;
import com.ofms.models.Fish;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("statistics")
@AllArgsConstructor
public class StatisticsController<M> {

    private final DataAspect dataAspect;


    @GetMapping("/data")
    public ResponseEntity<HashMap<String, DataStatistics>> getData() {
        return ResponseEntity.ok(dataAspect.getMap());
    }

    @GetMapping("/fish")
    public ResponseEntity<Fish> getFish() {
        return ResponseEntity.ok(dataAspect.getFish());}
}
