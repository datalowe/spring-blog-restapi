package com.datalowe.blogapi.config;

import java.util.List;

import com.datalowe.blogapi.models.Tag;
import com.datalowe.blogapi.repositories.TagRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TagConfig {
  
  @Bean
  CommandLineRunner tagCommandLineRunner(
    TagRepository tagRepository
  ) {
    return args -> {
      var t1 = new Tag(
        "Java"
      );
      var t2 = new Tag(
        "Python"
      );
      tagRepository.saveAll(List.of(t1, t2));
    };
  }
}
