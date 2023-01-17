package com.springboot.blog.controller;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;
    //Constructor based dependency Injection //@AutoWired can be ignored
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create blog post API
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    //get all posts rest api
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(value="pageNo",defaultValue = "0" ,required = false) int pageNo  ,
            @RequestParam(value="pageSize",defaultValue = "10" ,required = false) int pageSize
            ){

        return ResponseEntity.ok(postService.getAllPosts());
    }

    //get post by ID
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    //Update post by ID rest api
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name= "id") Long id){
        PostDto postResponse = postService.updatePost(postDto,id);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);

    }

    //delete post rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id){
        postService.deletePostById(id);
        return ResponseEntity.ok("post Entity Deleted successfully");
    }

}
