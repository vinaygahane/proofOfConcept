package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Post;
import com.springboot.blog.entity.PostResponse;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    //constructor based dependency Injection for Repository Injection
    private PostRepository postRepository;

    //@Autowired can be omitted here as class has only one constructor
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postdto) {

        //convert DTO to Entity
         Post post  = mapTOEntity(postdto);

         Post newPost = postRepository.save(post);

         //convert Entity to DTO
        PostDto postResponse = mapToDTO(newPost);

        return postResponse;
    }

    @Override
    public PostResponse getAllPosts(int pageNo , int pageSize,String sortBy,String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();

        //create Pageble Instance
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);//desc:- Sort.by(sortBy).descending()

       Page<Post> posts =  postRepository.findAll(pageable);

       //get content from Page object
        List<Post> listOfPosts = posts.getContent();


       List<PostDto> content=  listOfPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

       PostResponse postresponse = new PostResponse();
        postresponse.setContent(content);
        postresponse.setPageNo(posts.getNumber());
        postresponse.setPageSize(posts.getSize());
        postresponse.setTotalElements(posts.getTotalElements());
        postresponse.setTotalPages(posts.getTotalPages());
        postresponse.setLast(posts.isLast());

        return postresponse;



//       List<PostDto> response = new ArrayList<>();
//       for(Post p : posts)
//       {
//           response.add(mapToDTO(p));
//       }
//       return response;
    }

    @Override
    public PostDto getPostById(Long id) {
        PostDto response =  mapToDTO(postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id)));
        return response;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        //Get post by Id from database
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id));

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);
        return mapToDTO(updatedPost);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deletePostById(Long id) {
        //Get post by Id from database
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id));
        postRepository.delete(post);
    }


    //convert Entity into DTO
    private PostDto mapToDTO(Post post){
      PostDto postDto = new PostDto();
      postDto.setId(post.getId());
      postDto.setTitle(post.getTitle());
      postDto.setDescription(post.getDescription());
      postDto.setContent(post.getContent());
      return postDto;
    }

    //Convert DTO to Entity
    private Post mapTOEntity(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
    return post;
    }
}
