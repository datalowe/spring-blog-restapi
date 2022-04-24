package com.datalowe.blogapi.repositories;

import com.datalowe.blogapi.models.Post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
