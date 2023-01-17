package com.springboot.blog.service;

import com.springboot.blog.payload.PostDto;

import java.util.List;

public interface PostService {
  PostDto createPost(PostDto postdto);

  List<PostDto> getAllPosts(int pageNo , int pageSize);

   PostDto getPostById(Long id);

   PostDto updatePost(PostDto postDto,Long id);

   void deletePostById(Long id);
}
