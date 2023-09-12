package com.myshop.myShop.domain;

import com.myshop.myShop.dto.request.PostUpdateRequest;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter @Setter
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void updatePost(PostUpdateRequest dto) {

        this.title = dto.getTitle();
        this.content = dto.getContent();
    }
}
