package com.example.post_study.entity;

import com.example.post_study.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // 데이터베이스 테이블과 매핑될 클래스
@Table(name = "post") // 나중에 설명
@Getter
@Setter
@NoArgsConstructor // 기본 생성자 만들어줌
public class Post {
    //  글 번호
    @Id // 해당 필드를 엔티티의 primary key 로 지정한다
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    private Long id;

    //  제목, 작성자명, 작성 내용, 비밀번호

    //  필드를 데이터베이스 테이블의 열 (column) 과 매핑한다
    // name 속성은 매핑될 열의 이름을 지정하고
    // nullable 속성은 해당 열이 null 값을 허용하는지 여부를 나타낸다

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "password", nullable = false)
    private String password;


    // PostRequestDto 객체를 매개변수로 받는 생성자
    // 클라이언트로부터 전달받은 게시글 정보를 Post 엔티티의 필드에 초기화한다
    public Post(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.author = postRequestDto.getAuthor();
        this.content = postRequestDto.getContent();
        this.password = postRequestDto.getPassword();
    }
}
