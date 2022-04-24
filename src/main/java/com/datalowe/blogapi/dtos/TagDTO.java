package com.datalowe.blogapi.dtos;

import java.util.ArrayList;
import java.util.List;

import com.datalowe.blogapi.models.Post;
import com.datalowe.blogapi.models.Tag;

public class TagDTO {

  private Long id;
  private String name;
  private List<AbbrPostDTO> posts = new ArrayList<>();
  
  public TagDTO() {
  }

  public TagDTO(Tag tag) {
    this.id = tag.getId();
    this.name = tag.getName();
    tag.getPosts().forEach(p -> {
      AbbrPostDTO postDTO = new AbbrPostDTO();
      postDTO.setTitle(p.getTitle());
      postDTO.setSlug(p.getSlug());
      posts.add(postDTO);
    });
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public List<AbbrPostDTO> getPosts() {
    return this.posts;
  }

  public static Iterable<TagDTO>tagsToDTOs(Iterable<Tag> tags) {
    List<TagDTO> tagDTOs = new ArrayList<>();
    for (Tag t : tags) {
      tagDTOs.add(new TagDTO(t));
    }
    return tagDTOs;
  }

  private class AbbrPostDTO {
    private String title;
    private String slug;

    public AbbrPostDTO() {
    }

    public AbbrPostDTO(Post post) {
      this.title = post.getTitle();
      this.slug = post.getSlug();
    }

    public String getTitle() {
      return title;
    }

    public String getSlug() {
      return slug;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public void setSlug(String slug) {
      this.slug = slug;
    }
  }
}
