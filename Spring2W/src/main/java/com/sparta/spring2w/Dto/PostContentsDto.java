package com.sparta.spring2w.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class PostContentsDto {
    //    글 상세 조회
    private String title;
    private String contents;
    private String auther;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostContentsDto(String title, String contents, String auther, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.title = title;
        this.contents = contents;
        this.auther = auther;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public PostContentsDto(String title, String contents, LocalDateTime createdAt, LocalDateTime modifiedAt) {
    }
}
