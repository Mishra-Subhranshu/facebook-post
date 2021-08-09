package com.example.facebook.service;

import com.example.facebook.entity.Post;
import com.example.facebook.entity.User;
import com.example.facebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    /*public List<Post> getAllPost() {
        return postRepository.findAll();
    }*/
    /*public Post getById(Long id) {
        return postRepository.findById(id).get();
    }*/

    public List<Post> getAllPost() {

        List<Post> postList =  new ArrayList<Post>();
        postRepository.findAll().forEach(post -> postList.add(post));
        return postList;
    }

    public void saveOrUpdate(Post post) {
        System.out.println("fan");
        postRepository.save(post);

    }
    /*public void deleteUser(Long id) {
        postRepository.deleteById(id);
    }*/
}
