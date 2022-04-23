package com.datalowe.blogapi.models;

import java.time.LocalDate;

public class Post {
  private final long id;
  private String title;
  private String body;
  private String intro;
  private String slug;
  private LocalDate publicationDatetime;
  private LocalDate updatedDatetime;

  public Post(long id, String title, String body, String intro, String slug, LocalDate publicationDatetime, LocalDate updatedDatetime) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.intro = intro;
    this.slug = slug;
    this.publicationDatetime = publicationDatetime;
    this.updatedDatetime = updatedDatetime;
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

  public String getIntro() {
    return this.intro;
  }

  public String getSlug() {
    return this.slug;
  }

  public LocalDate getPublicationDatetime() {
    return this.publicationDatetime;
  }

  public LocalDate getUpdatedDatetime() {
    return this.updatedDatetime;
  }

  // private User author;
  // private List<Tag> tags;
}
