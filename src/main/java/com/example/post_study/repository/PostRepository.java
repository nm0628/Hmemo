package com.example.post_study.repository;


import com.example.post_study.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// JpaRepository 인터페이스를 확장(상속)하고 있는데,
// 이를 통해 게시물(Post) 엔티티에 대한 데이터베이스 접근을 담당하는 레포지토리 인터페이스
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}


// PostRepository 인터페이스는 JpaRepository<Post, Long> 를 상속받음

// 기능
// 1. CRUD 작업
//  save() findByID() findAll() deleteById() 등의 메서드를 사용
// 2. findAll(pageable pageable) 메서드를 사용해 페이징 및 정렬된 결과를 반환할 수 있다
