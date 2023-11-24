package com.bouali.banking.Controllers;


import com.bouali.banking.dto.UserDto;
import com.bouali.banking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(
            @RequestBody UserDto userDto
    ){
        return ResponseEntity.ok(service.save(userDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll(){
        return  ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserDto> findById(
            @PathVariable("user-id") Integer userId
    ){
        return ResponseEntity.ok(service.findById(userId));
    }

    @PatchMapping("/validate/{user-id}")
    public ResponseEntity<Integer> validateAccount(
            @PathVariable("user-id") Integer userId
    ){
        return ResponseEntity.ok(service.validateAccount(userId));
    }

    @PatchMapping("/invalidate/{user-id}")
    public ResponseEntity<Integer> invalidateAccount(
            @PathVariable("user-id") Integer userId
    ){
        return ResponseEntity.ok(service.invalidateAccount(userId));
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("user-id") Integer userId
    ) {
        service.delete(userId);
        return ResponseEntity.accepted().build();
    }


//    @PostMapping("/")
//    public void save(){
//
//    }
//
//    @GetMapping("/")
//    public void findall(){
//
//    }
//
//    @GetMapping("/{iduser}")
//    public void findById(@PathVariable("iduser") Integer id){
//
//    }
//
//    @GetMapping("/find")
//    public void search(
//            @RequestParam(required = false) String firstanme,
//            @RequestParam(required = false) String lastanme,
//            @RequestParam(required = false) int age){
//
//    }
//
//
//    @GetMapping("/find/{uni_criteria")
//    public void searchUnique(@PathVariable("uni_criteria") String criteria) {
//
//    }


}
