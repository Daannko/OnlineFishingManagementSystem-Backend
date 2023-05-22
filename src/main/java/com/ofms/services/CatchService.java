package com.ofms.services;

import com.ofms.dto.AddCatchRequest;
import com.ofms.models.Catch;
import com.ofms.models.Fish;
import com.ofms.repositories.CatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatchService {

    private final CatchRepository catchRepository;
    private final UserService userService;
    private final AuthService authService;
    private final FishService fishService;

    public Catch addCatch(AddCatchRequest addCatchRequest){
        Catch newCatch = Catch.builder()
                .userId(authService.getUserFromContext().getId())
                .dateTime(new Date())
                .lakeId((long) addCatchRequest.getLakeId())
                .build();

        newCatch = catchRepository.save(newCatch);

        List<Fish> fishes = new ArrayList<>();
        for(Fish f: addCatchRequest.getFishes()){
            f.setACatch(newCatch);
            f.setUserId(newCatch.getUserId());
            f.setDate(newCatch.getDateTime());
            Fish fish = fishService.save(f);
            fishes.add(fish);
        }
        newCatch.setFishes(fishes);

        Catch aCatch = catchRepository.save(newCatch);

        return aCatch;
    }

    public List<Catch> getUsersCatches(Long id){
        return catchRepository.findAllByUserId(id);
    }

    public List<Catch> getAllCatches(){
        return catchRepository.findAll();
    }


}
