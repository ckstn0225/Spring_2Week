package com.sparta.spring2w.Dto;

import lombok.Getter;

@Getter
public class RegisterDto {

    String username;
    String password;
    String password2;

    public RegisterDto(String username, String password, String password2) {
        this.username = username;
        this.password = password;
        this.password2 = password2;
    }
}
