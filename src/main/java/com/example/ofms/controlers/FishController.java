package com.example.ofms.controlers;

import com.example.ofms.models.Fish;
import com.example.ofms.services.FishService;
import com.example.ofms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("fish")
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
