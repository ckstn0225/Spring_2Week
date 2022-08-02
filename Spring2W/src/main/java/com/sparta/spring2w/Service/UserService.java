package com.sparta.spring2w.Service;

import com.sparta.spring2w.Dto.LoginDto;
import com.sparta.spring2w.Dto.RegisterDto;
import com.sparta.spring2w.Entity.PostUser;
import com.sparta.spring2w.Repository.UserRepository;
import com.sparta.spring2w.Security.provider.JWTAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final JWTAuthProvider jwtAuthProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(JWTAuthProvider jwtAuthProvider, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.jwtAuthProvider = jwtAuthProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public String registerUser(RegisterDto requestDto) {
        // 회원 ID 중복 확인
        String username = requestDto.getUsername();
        Optional<PostUser> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
        System.out.println(requestDto.getUsername());
        System.out.println(requestDto.getPassword());
        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());

        PostUser user = new PostUser(username, password);
        userRepository.save(user);
        return "회원가입 성공!";
    }


    public boolean UserLogin(LoginDto loginDto){
        PostUser user = userRepository.findByUsername(loginDto.getUsername())
                .orElse(null);
        if (user != null) {
            if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

}