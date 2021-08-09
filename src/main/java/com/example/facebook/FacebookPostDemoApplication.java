package com.example.facebook;

import com.example.facebook.entity.Post;
import com.example.facebook.entity.User;
import com.example.facebook.repository.PostRepository;
import com.example.facebook.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FacebookPostDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacebookPostDemoApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner mappingDemo(UserRepository userRepository,
										 PostRepository postRepository) {
		return args -> {


			//Post post=new Post(252,"Good Picture","100");
			//List<Post> postList=new ArrayList<>();
			//postList.add(post);

			//create a new user
			User user = new User("Subhranshu Mishra", "subhranshu@oodles.io");
			//User user1 = new User( "Subhranshu Mishra", "subhranshu@oodles.io");
			//save the book
			userRepository.save(user);

			//create and save new posts
			postRepository.save(new Post(252, "Good Picture", "100", user));
		};

	}*/

}
