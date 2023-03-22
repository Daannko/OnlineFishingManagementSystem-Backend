package com.example.ofms.controlers;

import com.example.ofms.dto.CatchRequest;
import com.example.ofms.dto.DeleteRequest;
import com.example.ofms.models.Catch;
import com.example.ofms.services.CatchService;
import com.example.ofms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("catch")
public class CatchController {

    private final CatchService catchService;
    private final UserService userService;


    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody CatchRequest catchRequest){
        catchService.save(catchRequest);
        return ResponseEntity.ok("Registered a catch");
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping()
    ResponseEntity<?> add(@RequestBody DeleteRequest deleteRequest){

        if(catchService.getById(deleteRequest.getId()).isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Catch doesn't exists");
        }

        if(catchService.delete(deleteRequest)) return ResponseEntity.ok("Catch was deleted");
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("You are not the owner of catch");
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/get/{userId}")
    ResponseEntity<List<Catch>> getUsersCatches(@PathVariable Long userId){
        return ResponseEntity.ok(catchService.getAllByUserId(userId));
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/get")
    ResponseEntity<List<Catch>> getUsersCatches(){
        return ResponseEntity.ok(catchService.getAllByUserId(userService.getContextUser().getId()));
    }


}
