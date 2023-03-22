package com.example.ofms.services;

import com.example.ofms.models.Fish;
import com.example.ofms.repositories.FishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FishService {

    private final FishRepository fishRepository;

    public Fish save(Fish fish){
        return fishRepository.save(fish);
    }

    public List<Fish> getAllByUserId(Long userId){
        return fishRepository.findAllByUserId(userId);
    }
}