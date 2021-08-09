package com.example.facebook.controller;

import com.example.facebook.entity.Post;
import com.example.facebook.entity.User;
import com.example.facebook.entity.UserPostDto;
import com.example.facebook.service.JoinQueryServices;
import com.example.facebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

   /* @PostMapping("/post")
    public long addUser(@RequestBody User user) {
        System.out.println("ghil");
        userService.saveOrUpdate(user);
        return user.getId();
    }*/

    // post all the data
    @PostMapping("/post")
    public long save(@RequestBody User user)
    {
        System.out.println("Post method called in Employee controller");
        userService.saveOrUpdate(user);
        return user.getId();
    }

    // get all users
    @GetMapping("/list")
    public List<User> list() {
        System.out.println("get method");
        return userService.getAllUser();
    }

    // get the data by id
    @GetMapping("/list/{id}")
    public User getById(@PathVariable long id) {

        return userService.getById(id);
    }

    //delete the User by id
    @DeleteMapping("/delete/id")
    public String deleteUser(@PathVariable(value = "id") long id) {
        userService.deleteUser(id);
        return "deleted successfully id = ";
    }

    //custom JPQL mapping
    @GetMapping("/custom")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/getByName/{userName}")
    public List<User> findAllUsersByName(@PathVariable("userName") String userName) {
        return userService.FindUsersByName(userName);
    }


    @GetMapping("/getByEmail/{userEmail}")
    public List<User> findAllUsersByEmail(@PathVariable("userEmail") String userEmail) {
        return userService.FindUsersByEmail(userEmail);
    }

    //native query mapping

    @GetMapping("/getName/{userName}")
    public List<User> getUsersByName(@PathVariable("userName") String userName) {
        return userService.getUsersByName(userName);
    }

    //criteria query mapping

    @GetMapping("/foundName/{userName}")
    public List<User> foundName(@PathVariable("userName") String userName){
        System.out.println("ghil");
        return userService.foundName(userName);
    }

    //ascending order of Name by criteria query
    @GetMapping("/foundNameAsc")
    public List<User> foundNameAsc() {
        List<User> getResponse= userService.foundNameAsc();
        return getResponse;
    }

    //greater than equal to {id}
    @GetMapping("/greater/{id}")
    public List<User> greaterThan(@PathVariable("id") long id) {
        List<User> getResponse= userService.greaterThan(id);
        return getResponse;
    }

    //like operator whose name starts with s
    @GetMapping("/like/{userName}")
    public List<User> likeBy(@PathVariable("userName") String userName) {
        List<User> getResponse = userService.likeBy(userName);
        return getResponse;

    }

    //OR operator using criteria
    @GetMapping("/or/{id}/{userName}")
    public List<User> orIdUserName(@PathVariable("id") long id,
                                   @PathVariable("userName") String userName ) {
        return userService.orIdUserName(id, userName);
    }

        @Autowired
        private JoinQueryServices joinQueryServices;


    //left outer join
    @GetMapping("/left")
    public ResponseEntity<List<UserPostDto>> getLeftJoin() {
        return new ResponseEntity<List<UserPostDto>>(joinQueryServices.getLeftJoin(), HttpStatus.OK);
    }

    //right join
    @GetMapping("/right")
    public ResponseEntity<List<UserPostDto>> getRightJoin() {
        return new ResponseEntity<List<UserPostDto>>(joinQueryServices.getRightJoin(), HttpStatus.OK);
    }

    //inner join
    @GetMapping("/inner")
    public ResponseEntity<List<UserPostDto>> getInnerJoin() {
        return new ResponseEntity<List<UserPostDto>>(joinQueryServices.getInnerJoin(), HttpStatus.OK);
    }

    //cross join
    @GetMapping("/cross")
    public ResponseEntity<List<UserPostDto>> getCrossJoin() {
        return new ResponseEntity<List<UserPostDto>>(joinQueryServices.getCrossJoin(), HttpStatus.OK);
    }


}
