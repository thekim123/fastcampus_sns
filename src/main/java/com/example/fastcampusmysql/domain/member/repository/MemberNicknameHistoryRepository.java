package com.example.fastcampusmysql.domain.member.repository;

import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.entity.MemberNicknameHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberNicknameHistoryRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final static String TABLE = "MemberNicknameHistory";
    private static final RowMapper<MemberNicknameHistory> rowMapper = (ResultSet resultSet, int rowNum) ->
            MemberNicknameHistory
                    .builder()
                    .id(resultSet.getLong("id"))
                    .memberId(resultSet.getLong("memberId"))
                    .nickname(resultSet.getString("nickname"))
                    .createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
                    .build();

    public List<MemberNicknameHistory> findAllByMemberId(long memberId) {
        var sql = String.format("select * from %s where memberId = :memberId", TABLE);
        var params = new MapSqlParameterSource().addValue("memberId", memberId);
        return namedParameterJdbcTemplate.query(sql, params, rowMapper);
    }


    public MemberNicknameHistory save(MemberNicknameHistory member) {
        /*
            member id를 보고 갱신 또는 삽입을 정함.
            반환값은 id를 담아서 반환한다.
         */
        if (member.getId() == null) {
            return insert(member);
        }

        throw new UnsupportedOperationException("MemberNicknameHistory는 갱신을 지원하지 않습니다.");
    }

    private MemberNicknameHistory insert(MemberNicknameHistory history) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName(TABLE)
                .usingGeneratedKeyColumns("id");

        SqlParameterSource params = new BeanPropertySqlParameterSource(history);
        var id = simpleJdbcInsert.executeAndReturnKey(params).longValue();
        return MemberNicknameHistory.builder()
                .id(id)
                .memberId(history.getMemberId())
                .nickname(history.getNickname())
                .createdAt(history.getCreatedAt())
                .build();
    }

}
