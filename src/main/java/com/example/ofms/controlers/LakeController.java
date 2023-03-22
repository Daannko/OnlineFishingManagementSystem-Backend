package com.example.ofms.controlers;

import com.example.ofms.dto.AddLakeRequest;
import com.example.ofms.dto.LocationRequest;
import com.example.ofms.services.LakeService;
import com.example.ofms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/catch")
public class LakeController {

    private final LakeService lakeService;
    private final UserService userService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/find/closest")
    ResponseEntity<?> getAllByUserId(@RequestBody LocationRequest locationRequest){
        return ResponseEntity.ok(lakeService.findClosest(locationRequest));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/add}")
    ResponseEntity<?> getUsersCatches(@RequestBody AddLakeRequest addLakeRequest){
        return ResponseEntity.ok(lakeService.save(addLakeRequest));
    }

}