package com.dnascto.ionic.practicing.controller;

import com.dnascto.ionic.practicing.model.Users;
import com.dnascto.ionic.practicing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
@RequestMapping("/user")
//@CrossOrigin(origins = {"https://dry-journey-31622.herokuapp.com", "http://localhost:8100"})
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/authenticate")
//    public ResponseEntity<Users> getLogin(@RequestBody DtoLogin dtoLogin){
//        if(userService.login(dtoLogin.getLogin(), dtoLogin.getPassword()) == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        return ResponseEntity.ok(userService.login(dtoLogin.getLogin(), dtoLogin.getPassword()));
//    }

    @GetMapping("/byId")
    public ResponseEntity<Users> getUserById(@RequestParam BigInteger id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/companyName")
    public ResponseEntity<String> getCompanyName(@RequestParam String id){
        return ResponseEntity.ok(userService.getCompanyName(new BigInteger(id)));
    }

    @PostMapping("/new")
    public ResponseEntity<Users> createUser(@RequestBody Users users){
        return ResponseEntity.ok(userService.createUser(users));
    }

    @PostMapping("/newCompany")
    public ResponseEntity<Users> createComapany(@RequestBody Users users){
        return ResponseEntity.ok(userService.createUser(users));
    }

    @PutMapping("/edit")
    public ResponseEntity<Users> editUser(@RequestBody Users users) {
        if (userService.editUser(users) != 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }
}
