package com.ofms.controllers;

import com.ofms.dto.AddCatchRequest;
import com.ofms.models.Catch;
import com.ofms.services.AuthService;
import com.ofms.services.CatchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("catch")
@AllArgsConstructor
public class CatchController {

    private final CatchService catchService;
    private final AuthService authService;
    @PostMapping()
    public ResponseEntity<Catch> reportACatch(@RequestBody AddCatchRequest addCatchRequest){

        Catch aCatch = catchService.addCatch(addCatchRequest);

        return ResponseEntity.ok(aCatch);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Catch>> getCaches(){
        return ResponseEntity.ok(catchService.getUsersCatches(authService.getUserFromContext().getId()));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Catch>> getCaches(@PathVariable Long id){
        return ResponseEntity.ok(catchService.getUsersCatches(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Catch>> getAllCaches(){
        return ResponseEntity.ok(catchService.getAllCatches());
    }

}
