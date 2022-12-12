package com.example.fastcampusmysql.domain.member.dto;

import java.time.LocalDate;


// record - 게터 세터를 자동으로 만들어주고 이것을 프로퍼티로 사용할 수 있게해준다. 자바 16부터 공식화됨.
public record RegisterMemberCommand(
        String email,
        String nickname,
        LocalDate birthDay
) {
}
