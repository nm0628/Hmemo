package com.example.post_study.service;


import com.example.post_study.dto.PostRequestDto;
import com.example.post_study.dto.PostResponseDto;
import com.example.post_study.entity.Post;
import com.example.post_study.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.util.SpringReactiveModelAdditionsUtils;

import java.util.List;

@Service
public class PostService {
    // 길만들기
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }






    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);  // entity 로 보냄
        Post savePost = postRepository.save(post);  // 마이에스큐앨  -외우기 문법임
        PostResponseDto postResponseDto = new PostResponseDto(savePost);  // ResponseDto
        return postResponseDto;
        }


    public List<PostResponseDto> getPosts() {
        return postRepository.findAll().stream().
                map(PostResponseDto::new).toList();
    }

    public PostResponseDto detailPost(Long id) {
        Post post = checkPost(id);
        post = postRepository.findById(id).get();
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }


    private Post checkPost(Long id){
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시물은 존재하지 않습니다."));
    }
}
