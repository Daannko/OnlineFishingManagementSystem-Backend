package com.ofms.controllers;

import com.ofms.dto.AddCatchRequest;
import com.ofms.models.Catch;
import com.ofms.services.AuthService;
import com.ofms.services.CatchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
@AllArgsConstructor
/*@CrossOrigin("*")*/
public class TestController {


    private final CatchService catchService;
    private final AuthService authService;
    @PostMapping("/catch")
    public ResponseEntity<Catch> reportACatch(@RequestBody AddCatchRequest addCatchRequest){
        //catchService.addCatch(addCatchRequest)
        return ResponseEntity.ok(catchService.addCatch(addCatchRequest));
    }

    @GetMapping("/{id}")
    public String firstEndpoint(@PathVariable("id") String s){
        return s;
    }


}