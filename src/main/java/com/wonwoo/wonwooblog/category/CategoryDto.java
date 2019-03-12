package com.wonwoo.wonwooblog.category;

import org.hibernate.validator.constraints.NotBlank; // !!!!!!!!!!!!!!!!!!!!!!!!!

import lombok.Data;

/**
 * CategoryDto
 */
@Data
public class CategoryDto {

    private Long id;

    @NotBlank
    private String name;
}