package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String body;

    //many posts in one comment
    @ManyToOne(fetch = FetchType.LAZY)//FetchType.Lazy tells to fetch just related entities from database when you use relationship
    @JoinColumn(name="post_id",nullable = false)//post_id will become foreign key
    private Post post;
}
