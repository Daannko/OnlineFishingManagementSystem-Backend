package com.ofms.controllers;

import com.ofms.dto.AddCatchRequest;
import com.ofms.models.Catch;
import com.ofms.services.AuthService;
import com.ofms.services.CatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatchController {

    private final CatchService catchService;
    private final AuthService authService;
    @PostMapping("/catch")
    public ResponseEntity<Void> reportACatch(@RequestBody AddCatchRequest addCatchRequest){
        catchService.addCatch(addCatchRequest);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/user/catches")
    public ResponseEntity<List<Catch>> getCaches(){
        return ResponseEntity.ok(catchService.getUsersCatches(authService.getUserFromContext().getId()));
    }

    @PostMapping("/user/catches/{id}")
    public ResponseEntity<List<Catch>> getCaches(@PathVariable Long id){
        return ResponseEntity.ok(catchService.getUsersCatches(id));
    }

}
