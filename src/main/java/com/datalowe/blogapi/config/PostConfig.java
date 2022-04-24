package com.datalowe.blogapi.config;

import java.util.List;

import com.datalowe.blogapi.models.Post;
import com.datalowe.blogapi.models.PostRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostConfig {
  
  @Bean
  CommandLineRunner commandLineRunner(
    PostRepository postRepository
  ) {
    return args -> {
      var p1 = new Post(
        "Title 1",
        "Body 1",
        "Blurb 1",
        "slug-1"
      );
      var p2 = new Post(
        "Title 2",
        "Body 2",
        "Blurb 2",
        "slug-2"
      );
      postRepository.saveAll(List.of(p1, p2));
    };
  }
}
