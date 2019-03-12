package com.wonwoo.wonwooblog.comment;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.wonwoo.wonwooblog.post.Post;

import lombok.Data;

/**
 * Comment
 */
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    private LocalDateTime regDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="POST_ID")
    private Post post;

    public Comment(){

    }

    public Comment(String content, Post post){
        this.content = content;
        this.post = post;
    }
    
}