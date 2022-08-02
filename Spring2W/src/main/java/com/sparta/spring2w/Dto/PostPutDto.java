package com.sparta.spring2w.Dto;

import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
public class PostPutDto {
    //    글 업데이트
    private String title;
    private String contents;
    private String auther;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public PostPutDto(String title, String contents, String auther, LocalDateTime modifiedAt) {
        this.title = title;
        this.contents = contents;
        this.auther = auther;
        this.modifiedAt = modifiedAt;
    }
}