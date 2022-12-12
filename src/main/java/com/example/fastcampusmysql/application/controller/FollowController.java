package com.example.fastcampusmysql.application.controller;

import com.example.fastcampusmysql.application.usacase.CreateFollowMemberUsacase;
import com.example.fastcampusmysql.application.usacase.GetFollowingMemberUsacase;
import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.entity.Member;
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
    private final CreateFollowMemberUsacase createFollowMemberUsacase;
    private final GetFollowingMemberUsacase getFollowingMemberUsacase;

    @PostMapping("/{fromId}/{toId}")
    public void create(@PathVariable long fromId, @PathVariable long toId){
        createFollowMemberUsacase.execute(fromId, toId);
    }

    @PostMapping("/members/{fromId}")
    public List<MemberDto> create(@PathVariable long fromId){
        return getFollowingMemberUsacase.execute(fromId);
    }


}
