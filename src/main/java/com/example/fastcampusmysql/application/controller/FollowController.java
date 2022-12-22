package com.example.fastcampusmysql.application.controller;

import com.example.fastcampusmysql.application.usecase.CreateFollowMemberUsecase;
import com.example.fastcampusmysql.application.usecase.GetFollowingMemberUsecase;
import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {
    private final CreateFollowMemberUsecase createFollowMemberUsacase;
    private final GetFollowingMemberUsecase getFollowingMemberUsacase;

    @PostMapping("/{fromId}/{toId}")
    public void create(@PathVariable long fromId, @PathVariable long toId){
        createFollowMemberUsacase.execute(fromId, toId);
    }

    @PostMapping("/members/{fromId}")
    public List<MemberDto> create(@PathVariable long fromId){
        return getFollowingMemberUsacase.execute(fromId);
    }


}
