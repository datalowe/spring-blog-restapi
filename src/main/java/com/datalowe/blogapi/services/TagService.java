package com.datalowe.blogapi.services;

import java.util.Optional;

import com.datalowe.blogapi.models.Tag;
import com.datalowe.blogapi.repositories.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
  private final TagRepository tagRepository;

  @Autowired
  public TagService(TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  public Iterable<Tag> getTags() {
    return tagRepository.findAll();
  }

  public Tag getTag(Long id) throws IllegalStateException {
    Optional<Tag> tag = tagRepository.findById(id);
    if (!tag.isPresent()) {
      throw new IllegalStateException(
        "Tag with id " + id + " does not exist."
      );
    } 
    return tag.get();
  }

  public void createTag(Tag tag) throws IllegalStateException {
    tagRepository.save(tag);
  }

  public boolean deleteTag(Long id) {
    boolean tagExists = tagRepository.existsById(id);
    if (!tagExists) {
      throw new IllegalStateException(
        "Tag with id " + id + " does not exist."
      );
    }
    tagRepository.deleteById(id);
    return true;
  }
}