package com.example.fastcampusmysql.domain.post.service;


import com.example.fastcampusmysql.domain.post.dto.DailyPostCount;
import com.example.fastcampusmysql.domain.post.dto.DailyPostCountRequest;
import com.example.fastcampusmysql.domain.post.dto.PostCommand;
import com.example.fastcampusmysql.domain.post.entity.Post;
import com.example.fastcampusmysql.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostReadService {
    private final PostRepository postRepository;

    public List<DailyPostCount> getDailyPostCount(DailyPostCountRequest request) {
        /*
            반환 값 -> 리스트[작성일자, 작성회원, 작성게시물 갯수]
            select createdDate, memberId, count(id)
            from post
            where memberId = :memberId and
            createddDate between firstDate and lastDate
            group by createdDate memberId
         */

        return postRepository.groupByCreatedDate(request);
    }
}
