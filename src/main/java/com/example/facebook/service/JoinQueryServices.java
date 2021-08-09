package com.example.facebook.service;

import com.example.facebook.entity.UserPostDto;
import com.example.facebook.repository.PostRepository;
import com.example.facebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinQueryServices {

    @Autowired
   private UserRepository userRepository;
    @Autowired
    private  PostRepository postRepository;

    public List<UserPostDto> getLeftJoin() {
        List<UserPostDto> list = userRepository.fetchLeftJoin();
        list.forEach(l -> System.out.println(l));
        return list;
    }

    public List<UserPostDto> getRightJoin() {
        List<UserPostDto> list = userRepository.fetchRightJoin();
        list.forEach(l -> System.out.println(l));
        return list;
    }

    public List<UserPostDto> getInnerJoin() {
        List<UserPostDto> list = userRepository.fetchInnerJoin();
        list.forEach(l -> System.out.println(l));
        return list;
    }

    public List<UserPostDto> getCrossJoin() {
        List<UserPostDto> list = userRepository.fetchCrossJoin();
        list.forEach(l -> System.out.println(l));
        return list;
    }
}
