package com.ofms.services;

import com.ofms.dto.AllFishResponse;
import com.ofms.models.Fish;
import com.ofms.models.User;
import com.ofms.repositories.FishRepository;
import com.ofms.repositories.LakeRepository;
import com.ofms.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FishService {

    private final FishRepository fishRepository;
    private final LakeRepository lakeRepository;
    private final UserRepository userRepository;

    public Fish save(Fish fish){
        return fishRepository.save(fish);
    }

    public List<Fish> gatAllYouWant(){return fishRepository.findAll();}

    public List<Fish> getAll(){
        return fishRepository.findAll();
    }


    public List<AllFishResponse> getAllFishes(int page, int size){

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC,"date");
        Page<Fish> fishes = fishRepository.findWithPagable(pageable);

        return fishes.getContent().stream().map(e -> {
            AllFishResponse allFishResponse = new AllFishResponse();
            User user = userRepository.getReferenceById(e.getUserId());
            lakeRepository.findById(e.getACatch().getLakeId()).ifPresent(lake -> allFishResponse.setLakeName(lake.getName()));
            allFishResponse.setUserNameAndSurname(user.getName() + " " + user.getSurname());
            allFishResponse.setFish(e);
            return allFishResponse;
        }).collect(Collectors.toList());

    }

    public Fish getById(Long id) {
        Optional<Fish> optional = fishRepository.findById(id);
        return optional.orElse(null);
    }
}