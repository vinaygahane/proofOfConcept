package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//No need to add @Repository because JpaRepository has implementation of SimpleJpaRepository
//@Transactional is also handled using above
public interface PostRepository extends JpaRepository<Post,Long > {
}
