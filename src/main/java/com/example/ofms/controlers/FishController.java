package com.example.ofms.controlers;

import com.example.ofms.models.Fish;
import com.example.ofms.services.FishService;
import com.example.ofms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/catch")
public class FishController {

    private final FishService fishService;
    private final UserService userService;


    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/get/all")
    ResponseEntity<?> getAllByUserId(){
        ;
        return ResponseEntity.ok(fishService.getAllByUserId(userService.getContextUser().getId()));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/get/{userId}")
    ResponseEntity<List<Fish>> getUsersCatches(@PathVariable Long userId){
        return ResponseEntity.ok(fishService.getAllByUserId(userId));
    }

}
