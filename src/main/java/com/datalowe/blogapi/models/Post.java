package com.datalowe.blogapi.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
  @Column(unique=true)
  private String title;
  private String body;
  private String blurb;
  @Column(unique=true)
  private String slug;
  private LocalDateTime publicationDatetime;
  private LocalDateTime updatedDatetime;

  @ManyToMany(cascade = {
    CascadeType.MERGE
  })
  @JoinTable(name = "post_tag",
      joinColumns = @JoinColumn(name = "post_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id")
  )
  private Set<Tag> tags = new HashSet<>();

  public Post() {
  }

  public Post(String title, String body, String blurb, String slug) {
    this.title = title;
    this.body = body;
    this.blurb = blurb;
    this.slug = slug;
    this.publicationDatetime = LocalDateTime.now();
    this.updatedDatetime = LocalDateTime.now();
  }

  public Post(String title, String body, String blurb, String slug, Tag[] tags) {
    this.title = title;
    this.body = body;
    this.blurb = blurb;
    this.slug = slug;
    this.publicationDatetime = LocalDateTime.now();
    this.updatedDatetime = LocalDateTime.now();
    List.of(tags).forEach(t -> addTag(t));
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

  public String getBlurb() {
    return this.blurb;
  }

  public String getSlug() {
    return this.slug;
  }

  public Set<Tag> getTags() {
    return this.tags;
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
      " id='" + getId() + "'" +
      ", title='" + getTitle() + "'" +
      ", body='" + getBody() + "'" +
      ", blurb='" + getBlurb() + "'" +
      ", slug='" + getSlug() + "'" +
      ", publicationDatetime='" + getPublicationDatetime() + "'" +
      ", updatedDatetime='" + getUpdatedDatetime() + "'" +
      "}";
  }

  public void addTag(Tag tag) {
    tags.add(tag);
    tag.getPosts().add(this);
  }

  public void removeTag(Tag tag) {
      tags.remove(tag);
      tag.getPosts().remove(this);
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Post)) return false;
      return id != null && id.equals(((Post) o).getId());
  }

  @Override
  public int hashCode() {
      return getClass().hashCode();
  }
}
