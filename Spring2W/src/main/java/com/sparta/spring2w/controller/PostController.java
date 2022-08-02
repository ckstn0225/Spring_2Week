package com.sparta.spring2w.controller;

import com.sparta.spring2w.Dto.PostContentsDto;
import com.sparta.spring2w.Dto.PostGetDto;
import com.sparta.spring2w.Dto.PostPutDto;
import com.sparta.spring2w.Service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    // 글 전체 조회
    @GetMapping("/api/posts")
    public List<PostGetDto> getPostInfo() {
        return postService.seelists();
    }

    //    글 상세 조회
    @GetMapping("/api/posts/{id}")
    public PostContentsDto getPostAll(@PathVariable Long id) {
        return postService.seeContents(id);
    }

    // 글 등록
    @PostMapping("/api/posts")
    public String createPost(@RequestBody PostPutDto requestDto) {
        return postService.WritePost(requestDto);

    }


    //    글 수정
    @PutMapping("/api/posts/{id}")
    public String updateCourse(@PathVariable Long id, @RequestBody PostPutDto requestDto) {
        return postService.update(id, requestDto);
    }

    //    글 삭제
    @DeleteMapping("/api/posts/{id}")
    public String deleteCourse(@PathVariable Long id) {
        return postService.DeletePost(id);
    }
}

