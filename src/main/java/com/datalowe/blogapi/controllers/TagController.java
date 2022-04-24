package com.datalowe.blogapi.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.datalowe.blogapi.dtos.TagDTO;
import com.datalowe.blogapi.models.Tag;
import com.datalowe.blogapi.services.TagService;

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
@RequestMapping(path="api/v1/tag")
public class TagController {
  private final TagService tagService;

  public TagController(TagService tagService) {
    this.tagService = tagService;
  }

  @GetMapping
  public @ResponseBody Iterable<TagDTO> listTags() {
    return TagDTO.tagsToDTOs(tagService.getTags());
  }

  @PostMapping
  public @ResponseBody String createTag(
      @RequestBody Tag tag
    ) {
      tagService.createTag(tag);
      return "Tag created";
  }

  @GetMapping("/{id}")
  public @ResponseBody ResponseEntity<?> detailTag(@PathVariable Long id) {
    try {
      Tag tag = tagService.getTag(id);
      return new ResponseEntity<>(new TagDTO(tag), HttpStatus.OK);
    } catch (IllegalStateException e) {
      Map<String, String> respObj = Collections.singletonMap("error", e.getMessage());
      return new ResponseEntity<>(respObj, HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("/{id}")
  public @ResponseBody Map<String, String> deleteTag(@PathVariable Long id) {
    Map<String, String> respObj = new HashMap<>();
    try {
      tagService.deleteTag(id);
      respObj.put("message", "tag deleted");
    } catch (IllegalStateException e) {
      respObj.put("error", e.getMessage());
    }
    return respObj;
  }
}
