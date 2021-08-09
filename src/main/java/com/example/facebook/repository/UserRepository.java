package com.example.facebook.repository;

import com.example.facebook.entity.User;
import com.example.facebook.entity.UserPostDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.form.SelectTag;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>, UserCustomRepository{

    //custom JPQL query
    @Query("SELECT u FROM User u")
    public List<User> findAllUsers();

    @Query("SELECT u FROM User u  WHERE u.userName=:s") //s refers to alias
    public List<User> FindUsersByName(@Param("s") String userName);

    @Query("SELECT u FROM User u WHERE u.userEmail=:d") //d refers to alias
    public List<User> FindUsersByEmail(@Param("d") String userEmail);


    //native query

    @Query(value = "select * from users  where user_name=:userName", nativeQuery = true) //q refers to alias
    public List<User> getUsersByName(String userName);

    //left join

    @Query("SELECT new com.example.facebook.entity.UserPostDto(u.userName, p.likes, p.comments,p.share)"
           + "FROM User u LEFT JOIN u.posts p")
    List<UserPostDto> fetchLeftJoin();

    //right join

    @Query("SELECT new com.example.facebook.entity.UserPostDto(u.userName, p.likes, p.comments, p.share)"
           + "FROM User u RIGHT JOIN u.posts p")
    List<UserPostDto> fetchRightJoin();

    //cross join

    @Query("SELECT new com.example.facebook.entity.UserPostDto(u.userName, p.likes, p.comments, p.share)"
            + "FROM User u,Post p")
    List<UserPostDto> fetchCrossJoin();

    @Query("SELECT new com.example.facebook.entity.UserPostDto(u.userName,u.userEmail, p.likes, p.comments, p.share)"
            + "FROM User u INNER JOIN u.posts p")
    List<UserPostDto> fetchInnerJoin();
}



    //criteria query

    /*@Query(value = "select s from User s where s.user_name=:g")
    public List<User> getNameUser(@Param("g") String userName);*/

