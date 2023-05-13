package com.blog.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    private String content;
    private UserDto user;
    private CategoryDto category;

}
