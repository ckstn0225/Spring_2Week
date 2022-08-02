package com.sparta.spring2w.Service;

import com.sparta.spring2w.Dto.PostContentsDto;
import com.sparta.spring2w.Dto.PostGetDto;
import com.sparta.spring2w.Dto.PostPutDto;
import com.sparta.spring2w.Entity.Post;
import com.sparta.spring2w.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    //    글 상세조회에서 사용되는 부분     [GET  api/posts/{id}]
    @Transactional
    public PostContentsDto seeContents(Long id) {
        Post post1 = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다."));
        return new PostContentsDto(post1.getTitle(), post1.getContents(),post1.getAuthor(), post1.getCreatedAt(),post1.getModifiedAt());
    }

    //    글 전체 조회 사용  [GET api/posts]
    public List<PostGetDto> seelists() {
        List<Post> tours = postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        List<PostGetDto> GetDto = new ArrayList<>();
        for (int i = 0; i < postRepository.count(); i++) {
            Post postinfo = tours.get(i);
            PostGetDto postGetDto = new PostGetDto(postinfo.getTitle(), postinfo.getAuthor(), postinfo.getCreatedAt(),postinfo.getModifiedAt());
            GetDto.add(postGetDto);
        }
        return GetDto;
    }

    //    글작성용

    @Transactional
    public String WritePost(PostPutDto requestDto){
        Post post = new Post(requestDto);
        postRepository.save(post);
        return  "ID: ["+post.getId()+"]의 저장완료";
    }

    //    Update에서 사용 [PUT api/posts/{id}]
    @Transactional
    public String update(Long id, PostPutDto updateDto) {
        Post post1 = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        post1.update(updateDto);
        return "ID: ["+post1.getId()+"]의 업데이트 완료!";
    }

//    글 삭제용
    @Transactional
    public String DeletePost(Long id){
        postRepository.deleteById(id);
        return "ID: ["+id+"]의 삭제 완료";
    }


}



