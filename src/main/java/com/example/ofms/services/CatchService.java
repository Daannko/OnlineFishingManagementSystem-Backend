package com.example.ofms.services;

import com.example.ofms.dto.CatchRequest;
import com.example.ofms.dto.DeleteRequest;
import com.example.ofms.models.Catch;
import com.example.ofms.repositories.CatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatchService {

    private final CatchRepository catchRepository;
    private final UserService userService;

    public Catch save(CatchRequest catchRequest){
        Catch aCatch = Catch.builder()
                .fishes(catchRequest.getFishes())
                .dateTime(catchRequest.getDate())
                .userId(userService.getContextUser().getId())
                .lakeId(catchRequest.getLakeId())
                .build();

        return catchRepository.save(aCatch);
    }

    public Optional<Catch> getById(Long Id){
        return catchRepository.findById(Id);
    }

    public boolean delete(DeleteRequest deleteRequest){
        Optional<Catch> aCatchOptional = catchRepository.findById(deleteRequest.getId());
        if(aCatchOptional.isEmpty()) return false;
        Catch aCatch = aCatchOptional.get();
        if(!aCatch.getUserId().equals(userService.getContextUser().getId())){
            return false;
        }
        catchRepository.delete(aCatch);
        return true;
    }

    public List<Catch> getAllByUserId(Long userId){
        return catchRepository.findAllByUserId(userId);
    }
}
