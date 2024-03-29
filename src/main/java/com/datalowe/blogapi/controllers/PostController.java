package com.datalowe.blogapi.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.datalowe.blogapi.dtos.PostDTO;
import com.datalowe.blogapi.models.Post;
import com.datalowe.blogapi.services.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/post")
public class PostController {
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public @ResponseBody Iterable<PostDTO> listPosts() {
    return PostDTO.postToDTOs(postService.getPosts());
  }

  @PostMapping
  public @ResponseBody String createPost(
      @RequestBody Post post
    ) {
      post.setDatetimesToNow();
      postService.createPost(post);
      return "Post created";
  }

  @GetMapping("/{id}")
  public @ResponseBody ResponseEntity<?> detailPost(@PathVariable Long id) {
    try {
      Post post = postService.getPost(id);
      return new ResponseEntity<>(new PostDTO(post), HttpStatus.OK);
    } catch (IllegalStateException e) {
      Map<String, String> respObj = Collections.singletonMap("error", e.getMessage());
      return new ResponseEntity<>(respObj, HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("/{id}")
  public @ResponseBody Map<String, String> deletePost(@PathVariable Long id) {
    Map<String, String> respObj = new HashMap<>();
    try {
      postService.deletePost(id);
      respObj.put("message", "post deleted");
    } catch (IllegalStateException e) {
      respObj.put("error", e.getMessage());
    }
    return respObj;
  }
}
