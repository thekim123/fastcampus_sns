package com.example.fastcampusmysql.util;


/*
    커서키는 unique가 보장되어야 한다.
    default key와 마지막임을 알려주는 키가 있어야됨
 */
public record CursorRequest(Long key, Integer size) {

    public static final Long NONE_KEY = -1L;

    public Boolean hasKey() {
        return key != null;
    }

    public CursorRequest next(Long key) {
        return new CursorRequest(key, size);
    }
}
