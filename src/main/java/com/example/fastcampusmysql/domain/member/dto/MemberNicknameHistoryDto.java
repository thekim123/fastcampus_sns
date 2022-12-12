package com.example.fastcampusmysql.domain.member.dto;

import java.time.LocalDateTime;

public record MemberNicknameHistoryDto(
        long id,
        long memberId,
        String nickname,
        LocalDateTime createdAt

) {
}
