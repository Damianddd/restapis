package com.example.restapis.controller;

import com.example.restapis.controller.dto.PostDto;
import com.example.restapis.model.Post;
import com.example.restapis.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPost(@RequestParam(required = false) int page){
        int pageNumber = page >= 0 ? page : 0;
        return PostDtoMapper.mapToPostDtos(postService.getPost(pageNumber));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostWithComment(@RequestParam(required = false) int page){
        int pageNumber = page >= 0 ? page : 0;
        return postService.getPostWithComments(pageNumber);
    }


    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id){
        return  postService.getSinglePost(id);
    }
}
