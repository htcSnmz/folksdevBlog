package com.folksdev.blog.controller;

import com.folksdev.blog.dto.CreateBlogDto;
import com.folksdev.blog.dto.CreateBlogRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/blog")
public class BlogController {

    @GetMapping
    public ResponseEntity<String> getBlog() {
        return ResponseEntity.ok("Hello Blog!");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> getBlogWithId(@PathVariable String id) {
        return ResponseEntity.ok("Hello Blog from");
    }

    @PostMapping
    public ResponseEntity<CreateBlogDto> createBlog(@Valid @RequestBody CreateBlogRequest createBlogRequest) {
        CreateBlogDto createBlogDto = new CreateBlogDto(createBlogRequest.getWriter(), createBlogRequest.getTitle());
        return new ResponseEntity<>(createBlogDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateBlog(@RequestBody String id) {
        return ResponseEntity.ok("id: " + id + " is updated");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable String id) {
        return ResponseEntity.ok("id: " + id + " is deleted");
    }
}
