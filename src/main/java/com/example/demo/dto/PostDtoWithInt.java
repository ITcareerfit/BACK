package com.example.demo.dto;

import java.util.List;

public class PostDtoWithInt {
    private List<PostDto> postDto;
    private int total;

    public PostDtoWithInt(List<PostDto> pagedPostDtos, int total) {
        this.postDto = pagedPostDtos;
        this.total = total;
    }

    public List<PostDto> getPostDto() {
        return postDto;
    }

    public void setPostDto(List<PostDto> postDto) {
        this.postDto = postDto;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int intValue) {
        this.total = total;
    }
}