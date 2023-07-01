package com.example.post_study.dto;


import lombok.Getter;

@Getter
// Setter 필요없음

public class PostRequestDto {

    private String title;
    private String author;
    private String content;
    private String password;

//    Setter 메서드가 필요하지 않은 이유는????
//    생성된 PostRequestDto 객체의 필드 값은
//    초기화된 이후에 변경되면 안되기 떄문

}
