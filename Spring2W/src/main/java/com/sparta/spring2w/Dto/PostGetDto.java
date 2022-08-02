package com.sparta.spring2w.Dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostGetDto {
    //    글 전체 조회
    private String title;
    private String auther;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostGetDto(String title, String auther, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.title = title;
        this.auther = auther;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
