package com.example.didip;

import com.example.didip.login.domain.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    @Disabled
    @DisplayName("V1_실패")
    void loginV1() {
        // given
        User user = new User();

        // when
        user.loginV1();

        // then
        // 로그인 메서드 호출시간과 결과 비교시점이 다르기에, 시간을 정확하게 테스트 하기 힘들다 -> 테스트가 보내는 신호
        assertThat(user.getLastLoginTimestamp()).isEqualTo(Clock.systemUTC().millis());
    }

    @Test
    @DisplayName("V2_유저_의존성주입")
    void loginV2() {
        // given
        User user = new User();
        Clock clock = Clock.fixed(Instant.parse("2000-01-01T00:00:00.00Z"), ZoneOffset.UTC);

        // when
        // 의존성 주입은 드러내는게 좋다
        user.loginV2(clock);

        // then
        assertThat(user.getLastLoginTimestamp()).isEqualTo(946684800000L);
    }

}