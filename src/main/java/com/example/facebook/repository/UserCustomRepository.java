package com.example.facebook.repository;

import com.example.facebook.entity.Post;
import com.example.facebook.entity.User;

import java.util.List;

public interface UserCustomRepository {
    public List<User> foundName(String userName);

    public List<User> foundNameAsc();

    public List<User> greaterThan(long id);

    public List<User> likeBy(String userName);

    public List<User>  orIdUserName(long id, String userName);

    }

