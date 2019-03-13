package com.wonwoo.wonwooblog.comment;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * CommentDto
 */
@Data
public class CommentDto {

    @NotNull
    private Long postId;

    @NotBlank
    private String content;
}