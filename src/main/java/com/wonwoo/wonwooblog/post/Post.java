package com.wonwoo.wonwooblog.post;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Post
 */
@Data
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    @Lob
    @NotNull
    private String content;

    @Lob
    private String code;

    public Post(){

    }

    @Enumerated(EnumType.STRING)
    private PostStatus status;

    private LocalDateTime regDate;

    public Post(Long id){
        this.id = id;
    }

    public Post(String title, PostStatus status){
        this.title = title;
        this.status = status;
    }

    public Post(Long id, String title, String content, String code, PostStatus status){
        this.id = id;
        this.title = title;
        this.content = content;
        this.code = code;
        this.status = status;
    }

    public Post(String title, String content, String code, PostStatus status){
        this.title = title;
        this.content = content;
        this.code = code;
        this.status = status;
    }
}