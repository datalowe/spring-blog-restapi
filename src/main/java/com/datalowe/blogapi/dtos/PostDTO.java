package com.datalowe.blogapi.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.datalowe.blogapi.models.Post;
import com.datalowe.blogapi.models.Tag;

// https://stackoverflow.com/questions/67886252/spring-boot-jpa-infinite-loop-many-to-many
public class PostDTO { 

  private Long id;
  private String title;
  private String body;
  private String blurb;
  private String slug;
  private LocalDateTime publicationDatetime;
  private LocalDateTime updatedDatetime;
  private List<TagDTO> tags = new ArrayList<>();   

  public PostDTO() { 
  }
   
  public PostDTO(Post post) {
       this.id = post.getId();
       this.title = post.getTitle();
       this.body = post.getBody();
       this.blurb = post.getBlurb();
       this.slug = post.getSlug();
       this.publicationDatetime = post.getPublicationDatetime();
       this.updatedDatetime = post.getUpdatedDatetime();
       for(Tag tag : post.getTags()) {
            TagDTO tagDTO = new TagDTO();
            tagDTO.setId(tag.getId());
            tagDTO.setName(tag.getName());
            tags.add(tagDTO);
       }
   }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }


  public Long getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }


  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getBlurb() {
    return this.blurb;
  }

  public void setBlurb(String blurb) {
    this.blurb = blurb;
  }

  public String getSlug() {
    return this.slug;
  }


  public LocalDateTime getPublicationDatetime() {
    return this.publicationDatetime;
  }

  public void setPublicationDatetime(LocalDateTime publicationDatetime) {
    this.publicationDatetime = publicationDatetime;
  }

  public LocalDateTime getUpdatedDatetime() {
    return this.updatedDatetime;
  }

  public void setUpdatedDatetime(LocalDateTime updatedDatetime) {
    this.updatedDatetime = updatedDatetime;
  }

  public List<TagDTO> getTags() {
    return this.tags;
  }

  public void setTags(List<TagDTO> tags) {
    this.tags = tags;
  }

  public static Iterable<PostDTO> postToDTOs(Iterable<Post> posts) {
    List<PostDTO> postDTOs = new ArrayList<>();
    for (Post p : posts) {
      postDTOs.add(new PostDTO(p));
    }
    return postDTOs;
  }
}