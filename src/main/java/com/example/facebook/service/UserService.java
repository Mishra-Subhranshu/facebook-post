package com.example.facebook.service;

import com.example.facebook.entity.User;

import com.example.facebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //public List<User> getAllUser() {
        //return userRepository.findAll();
   // }

    public User getById(long id) {

        return userRepository.findById(id).get();
    }

    public List<User> getAllUser() {
        List<User> userList = new ArrayList<User>();
        userRepository.findAll().forEach(user -> userList.add(user));
        return userList;
    }

    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public List<User> FindUsersByName( String userFirstName) {
        return userRepository.FindUsersByName(userFirstName);
    }

    public List<User> FindUsersByEmail(String userEmail) {
        return userRepository.FindUsersByEmail(userEmail);
    }

    //native query

    public List<User> getUsersByName(String userName) {
        return userRepository.getUsersByName(userName);
    }


    public List<User> foundName(String userName) {
        System.out.println("criteria");
      return userRepository.foundName(userName);
    }

    public List<User> foundNameAsc() {
        return userRepository.foundNameAsc();
    }


    public List<User> greaterThan(long id) {
        return userRepository.greaterThan(id);
    }

    public List<User> likeBy(String userName) {
        return userRepository.likeBy(userName);
    }

    public List<User> orIdUserName(long id, String userName) {
        return userRepository.orIdUserName(id, userName);
    }
}
