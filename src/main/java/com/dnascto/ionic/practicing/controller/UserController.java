package com.dnascto.ionic.practicing.controller;

import com.dnascto.ionic.practicing.model.User;
import com.dnascto.ionic.practicing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8100")
public class UserController {
    private UserService userService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    public ResponseEntity<User> getLogin(@RequestBody DtoLogin dtoLogin){
//        if(userService.login(dtoLogin.getLogin(), dtoLogin.getPassword()) == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        return ResponseEntity.ok(userService.login(dtoLogin.getLogin(), dtoLogin.getPassword()));
//    }

    @GetMapping("/byId")
    public ResponseEntity<User> getUserById(@RequestParam int id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestBody User user){
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/edit")
    public ResponseEntity<User> editUser(@RequestBody User user) {
        if (userService.editUser(user) != 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

}
