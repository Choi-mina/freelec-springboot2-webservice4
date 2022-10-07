package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 어노테이션 순서
 * @Getter, @NoArgsConstructor : 롬복 어노테이션
 * 주요 어노테이션인 @Entity를 클래스에 가깝게 두고 롬복 어노테이션을 그 위에 둠
 * */
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity{

    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 나타냄
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
