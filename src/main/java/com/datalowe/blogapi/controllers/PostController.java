package com.datalowe.blogapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

import com.datalowe.blogapi.models.Post;

@RestController
public class PostController {
  // @GetMapping("/post")
  // public Post[] listPosts() {

  // }

  // TODO: update this to /post/{id} or whatever is used in Spring
  @GetMapping("/post")
  public Post detailPost() {
    return new Post(
      1,
      "Foo title",
      "Bar body",
      "Qux intro",
      "Baz slug",
      LocalDate.of(2022, Month.APRIL, 22),
      LocalDate.of(2022, Month.APRIL, 22)
    );
  }
}
