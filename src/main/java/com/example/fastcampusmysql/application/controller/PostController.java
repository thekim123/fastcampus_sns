package com.example.fastcampusmysql.application.controller;


import com.example.fastcampusmysql.domain.post.dto.DailyPostCount;
import com.example.fastcampusmysql.domain.post.dto.DailyPostCountRequest;
import com.example.fastcampusmysql.domain.post.dto.PostCommand;
import com.example.fastcampusmysql.domain.post.service.PostReadService;
import com.example.fastcampusmysql.domain.post.service.PostWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostWriteService postWriteService;
    private final PostReadService postReadService;

    @PostMapping("")
    public Long create(PostCommand command) {
        return postWriteService.create(command);
    }

    @GetMapping("/daily-post-counts")
    public List<DailyPostCount> getDailyPostCounts(@RequestParam Long memberId, @RequestParam String firstDate, @RequestParam String lastDate) {
        System.out.println("ㅎㅇ");
        DailyPostCountRequest request = new DailyPostCountRequest(memberId, LocalDate.parse(firstDate), LocalDate.parse(lastDate));
        System.out.println(request.firstDate());
        return postReadService.getDailyPostCount(request);
    }
}
