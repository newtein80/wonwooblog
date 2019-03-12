package com.wonwoo.wonwooblog.post;

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
}