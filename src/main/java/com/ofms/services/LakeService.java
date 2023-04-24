package com.ofms.services;


import com.ofms.dto.AddLakeRequest;
import com.ofms.dto.LocationRequest;
import com.ofms.models.Lake;
import com.ofms.repositories.LakeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LakeService {

    private final LakeRepository lakeRepository;

    public Lake save(AddLakeRequest addLakeRequest){
        Lake lake = Lake.builder()
                .name(addLakeRequest.getName())
                .area(addLakeRequest.getArea())
                .volume(addLakeRequest.getVolume())
                .maxDepth(addLakeRequest.getMaxDepth())
                .waterQuality(addLakeRequest.getWaterQuality())
                .averageTemperature(addLakeRequest.getAverageTemperature())
                .phLevel(addLakeRequest.getPhLevel())
                .lat(addLakeRequest.getLat())
                .lng(addLakeRequest.getLng()).build();
        return lakeRepository.save(lake);
    }

    public Lake findClosest(LocationRequest locationRequest){
        return null;
    }



}