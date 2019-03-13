package com.wonwoo.wonwooblog.post;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * PostDto
 */
@Data
public class PostDto {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private String code;

    @NotNull
    private Long categoryId;

    private String categoryName;
}