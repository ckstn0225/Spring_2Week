package com.sparta.spring2w.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    String username;
    String password;

    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
