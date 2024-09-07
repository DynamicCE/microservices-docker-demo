package com.erkan.api.controller;

import com.erkan.business.UserService;
import com.erkan.model.User;
import com.erkan.repository.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public
class UserApi {

    private UserService userService;
    public
    UserApi ( UserService userService ) {
        this.userService = userService;
    }
    @PostConstruct
    public void init(){
        User user = new User();
        user.setFirstName ( "Yest" );
        user.setLastName ( "Noo" );
        userService.save ( user );
    }




    @PostMapping
    public
    ResponseEntity<User> add(@RequestBody User user){
        User result = userService.save(user);
        return ResponseEntity.ok (  result);
    }
    @GetMapping
    public
    ResponseEntity<List<User>> listAll( ){
        return ResponseEntity.ok ( userService.findAll() );
    }
}
