package com.example.post_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post") // 나중에 설명
@Getter
@Setter
@NoArgsConstructor // 기본 생성자 만들어줌
public class Post {
    //  글 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    private Long id;

    //  제목, 작성자명, 작성 내용, 비밀번호

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "password", nullable = false)
    private String password;




}
