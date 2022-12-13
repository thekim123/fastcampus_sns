package com.example.fastcampusmysql.domain.post.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record DailyPostCountRequest(
        Long memberId,
        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate firstDate,
        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lastDate
) {
}
