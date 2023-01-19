package com.springboot.blog.service;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(Long PostId,CommentDto commentdto);

    List<CommentDto> getCommentByPostId(Long postId);

    CommentDto getCommentById(Long postId,Long CommentId);

    CommentDto updateComment(Long postId,Long commentId,CommentDto commentDto);

    void deleteComment(Long postId,Long commentId );
}
