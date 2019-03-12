package com.wonwoo.wonwooblog.post;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.wonwoo.wonwooblog.category.Category;
import com.wonwoo.wonwooblog.comment.Comment;

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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

    @OneToMany(mappedBy="post", fetch=FetchType.LAZY) // One 의 대상이 되는 객체의 이름 ?????
    private List<Comment> comments;

    public Post(String title, String content, String code, PostStatus status, Category category){
        this.title = title;
        this.content = content;
        this.code = code;
        this.status = status;
        this.category = category;
    }
}