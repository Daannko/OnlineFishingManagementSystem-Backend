package com.ofms.controllers;

import com.ofms.services.FishService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fish")
@AllArgsConstructor
public class FishController {

    private final FishService fishService;
    @GetMapping("/all")
    public ResponseEntity<?> getFishes(@RequestParam(defaultValue = "0") String page,@RequestParam(defaultValue = "10") String size){
        return ResponseEntity.ok(fishService.getAllFishes(Integer.parseInt(page),Integer.parseInt(size)));
    }

    @GetMapping("/{id}}")
    public ResponseEntity<?> getFishes(@PathVariable Long id){
        return ResponseEntity.ok(fishService.getById(id));
    }

    @GetMapping("/alll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(fishService.getAll());
    }
}
