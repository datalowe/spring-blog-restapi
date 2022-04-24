package com.datalowe.blogapi.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Post {
  @Id
  @SequenceGenerator(
    name = "post_sequence",
    sequenceName = "post_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy=GenerationType.SEQUENCE,
    generator="post_sequence"
  )
  private Long id;
  private String title;
  private String body;
  private String blurb;
  private String slug;
  private LocalDateTime publicationDatetime;
  private LocalDateTime updatedDatetime;

  public Post() {
  }

  public Post(long id, String title, String body, String blurb, String slug) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.blurb = blurb;
    this.slug = slug;
    this.publicationDatetime = LocalDateTime.now();
    this.updatedDatetime = LocalDateTime.now();
  }

  public Post(String title, String body, String blurb, String slug) {
    this.title = title;
    this.body = body;
    this.blurb = blurb;
    this.slug = slug;
    this.publicationDatetime = LocalDateTime.now();
    this.updatedDatetime = LocalDateTime.now();
  }

  public long getId() {
    return this.id;
  }


  public String getTitle() {
    return this.title;
  }

  public String getBody() {
    return this.body;
  }

  public String getblurb() {
    return this.blurb;
  }

  public String getSlug() {
    return this.slug;
  }

  public LocalDateTime getPublicationDatetime() {
    return this.publicationDatetime;
  }

  public LocalDateTime getUpdatedDatetime() {
    return this.updatedDatetime;
  }

  public void setId(Long id) {
    this.id = id;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public void setBody(String body) {
    this.body = body;
  }
  public void setblurb(String blurb) {
    this.blurb = blurb;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }
  public void setPublicationDatetime(LocalDateTime publicationDatetime) {
    this.publicationDatetime = publicationDatetime;
  }
  public void setUpdatedDatetime(LocalDateTime updatedDatetime) {
    this.updatedDatetime = updatedDatetime;
  }
  public void setDatetimesToNow() {
    this.publicationDatetime = LocalDateTime.now();
    this.updatedDatetime = LocalDateTime.now();
  }

  @Override
  public String toString() {
    return "{" +
      // " id='" + getId() + "'" +
      ", title='" + getTitle() + "'" +
      ", body='" + getBody() + "'" +
      ", blurb='" + getblurb() + "'" +
      ", slug='" + getSlug() + "'" +
      // ", publicationDatetime='" + getPublicationDatetime() + "'" +
      // ", updatedDatetime='" + getUpdatedDatetime() + "'" +
      "}";
  }



  // private User author;
  // private List<Tag> tags;
}
