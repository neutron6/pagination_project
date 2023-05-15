package com.rsn.pagination.pagination_with_sorting.controller;

import com.rsn.pagination.pagination_with_sorting.model.User;
import com.rsn.pagination.pagination_with_sorting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save/{user}/{id}")
    public ResponseEntity<User> createAccount(@RequestBody User user, @PathVariable int id) {
        return ResponseEntity.ok(userService.createUser(user, id));
    }

    @GetMapping("/getdata")
    public ResponseEntity<List<User>> getUserdata() {
        return ResponseEntity.ok(userService.getAllUserData());
    }

    @GetMapping("/getdatabyid/{userId}")
    public ResponseEntity<Optional<User>> getDataById(@PathVariable long userId)
    {
        return ResponseEntity.ok(userService.getDataById(userId));
    }
}
