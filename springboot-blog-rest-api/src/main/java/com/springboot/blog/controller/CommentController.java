package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
 private CommentService commentService;

 public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //Rest api to create comment for a postId
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") Long postId,
                                                    @RequestBody CommentDto commentDto){
       return new ResponseEntity<>(commentService.createComment(postId,commentDto), HttpStatus.CREATED);
    }

    //Rest api to get all comments for post
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable(value = "postId") Long postId){
     return ResponseEntity.ok(commentService.getCommentByPostId(postId));
    }

    //RestApi to get comment by its id for a post with postId
   @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") Long postId,
                                                     @PathVariable(value = "id")Long commentId){
     return ResponseEntity.ok(commentService.getCommentById(postId,commentId));
    }

    //RestApi to Update comment by its id for a post with postId
    @PutMapping("/posts/{postId}/comments/{id}")

    public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") Long postId,
                                                    @PathVariable(value = "id") Long commentId,
                                                    @RequestBody CommentDto commentDto){
        System.out.println("check");

        CommentDto updatedComment = commentService.updateComment(postId,commentId,commentDto);
     return ResponseEntity.ok(updatedComment);
    }

    //RestApI to Delete comment by its id for a post with postId
    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
                                                @PathVariable(value = "id") Long commentId){
     commentService.deleteComment(postId,commentId);
     return ResponseEntity.ok("Comment Deleted successfully ");
    }

}
