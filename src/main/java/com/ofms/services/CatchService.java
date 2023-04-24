package com.ofms.services;

import com.ofms.dto.AddCatchRequest;
import com.ofms.models.Catch;
import com.ofms.repositories.CatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CatchService {

    private final CatchRepository catchRepository;
    private final UserService userService;
    private final AuthService authService;

    public void addCatch(AddCatchRequest addCatchRequest){
        Catch newCatch = new Catch().builder()
                .userId(authService.getUserFromContext().getId())
                .dateTime(new Date())
                .lakeId((long) addCatchRequest.getLakeId())
                .build();
//
//        newCatch.setFishes(addCatchRequest.getFishes().stream().map(e ->
//            Fish.builder()
//                    .aCatch(newCatch)
//                    .taken(e.taken)
//                    .weight(e.weight)
//                    .length(e.length)
//                    .species(e.species)
//                    .build()).toList()
//        );

        catchRepository.save(newCatch);
    }

    public List<Catch> getUsersCatches(Long id){
        return catchRepository.findAllByUserId(id);
    }

}
