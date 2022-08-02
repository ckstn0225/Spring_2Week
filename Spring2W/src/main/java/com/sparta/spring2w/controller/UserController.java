package com.sparta.spring2w.controller;

import com.sparta.spring2w.Dto.LoginDto;
import com.sparta.spring2w.Dto.RegisterDto;
import com.sparta.spring2w.Repository.UserRepository;
import com.sparta.spring2w.Security.UserDetailsImpl;
import com.sparta.spring2w.Security.jwt.JwtTokenUtils;
import com.sparta.spring2w.Security.provider.JWTAuthProvider;
import com.sparta.spring2w.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@AllArgsConstructor
public class UserController {

    private final JWTAuthProvider jwtAuthProvider;

    private final UserRepository userRepository;

    private final UserService userService;

    @ResponseBody
    @PostMapping("/register")
    public String register (@RequestBody RegisterDto registerDto){

        return userService.registerUser(registerDto);
    }

    @ResponseBody
    @PostMapping("/login")
    public String login (@RequestBody LoginDto loginDto){
        if (userService.UserLogin(loginDto)) {
            return "로그인 성공!";
        } else {
            return "닉네임 또는 패스워드를 확인해주세요!";
        }
    }

}
