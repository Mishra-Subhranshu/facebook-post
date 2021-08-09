package com.example.facebook.controller;

import com.example.facebook.entity.Post;
import com.example.facebook.entity.User;
import com.example.facebook.service.PostService;
import com.example.facebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    /*@PostMapping("/edit")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        System.out.println("ghil");
        return new ResponseEntity<Post>(postService.saveOrUpdate(post), HttpStatus.CREATED);
    }*/

    @PostMapping("/save")
    public long savePost(@RequestBody Post post)
    {
        System.out.println("Post method is called in Dept controller-------------------");
        postService.saveOrUpdate(post);
        return post.getId();
    }

    @GetMapping("/dept")
    public List<Post> getAllPost()
    {
        System.out.println("Get method called in Department controller");
        return postService.getAllPost();
    }
   /* @GetMapping("/listPost")
    public List<Post> list() {
        System.out.println("get method");
        return postService.getAllPost();
    }*/
  /*  @GetMapping("/post/{id}")
    public Post getById(@PathVariable Long id) {
        return postService.getById(id);
    }*/
}
