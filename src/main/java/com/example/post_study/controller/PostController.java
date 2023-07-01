package com.example.post_study.controller;

import com.example.post_study.dto.PostRequestDto;
import com.example.post_study.dto.PostResponseDto;
import com.example.post_study.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// CRUD
@RestController  // 해당 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타낸다
@RequestMapping("/api")
public class PostController {

    private final PostService postService;
    // PostService 타입의 멤버변수 postService 를 선언한다
    // 의존성 주입을 통해 PostController 에 PostService 의 인스턴스를 주입한다


    // PostController 클래스의 생성자
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시물 생성
    // 클라이언트로부터 받은 postRequestDto 를 사용하여 게시물을 생성한다
    // 생성된 게시물의 정보를 담은 PostResponseDto 객체를 반환한다
    // 이 반환값은 클라이언트에게 응답으로 전송된다
    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto){
        return postService.createPost(postRequestDto);
    }


    // getPosts() 메소드
    // 반환타입 List<PostResponseDto>!
    //  클라이언트에게는 게시물 목록을 PostResponseDto 의 리스트로 응답


    // postService.getPosts() 를 호출하여 모든 게시물을 가져와서
    // List<PostResponseDto> 형태로 반홚나다
    // PostResponseDto 는 게시물의 필요한 정보를 다은 데이터 전송 객체(DTO)다

    // *** postService -> postResponseDto
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts(){
        return postService.getPosts();
    }



    @GetMapping("/post/{id}")
    public PostResponseDto detailPost(@PathVariable Long id){
        return postService.detailPost(id);
    }

}
