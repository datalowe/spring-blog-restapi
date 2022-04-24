package com.datalowe.blogapi.services;

import java.util.Optional;

import com.datalowe.blogapi.models.Post;
import com.datalowe.blogapi.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  private final PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public Iterable<Post> getPosts() {
    return postRepository.findAll();
  }

  public Post getPost(Long id) throws IllegalStateException {
    Optional<Post> post = postRepository.findById(id);
    if (!post.isPresent()) {
      throw new IllegalStateException(
        "Post with id " + id + " does not exist."
      );
    } 
    return post.get();
  }

  public void createPost(Post post) throws IllegalStateException {
    postRepository.save(post);
  }

  public boolean deletePost(Long id) {
    boolean postExists = postRepository.existsById(id);
    if (!postExists) {
      throw new IllegalStateException(
        "Post with id " + id + " does not exist."
      );
    }
    postRepository.deleteById(id);
    return true;
  }
}