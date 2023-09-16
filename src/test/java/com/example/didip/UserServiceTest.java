package com.example.didip;

import com.example.didip.clock.TestClockHolder;
import com.example.didip.login.domain.User;
import com.example.didip.login.service.UserServiceV2;
import com.example.didip.login.service.UserServiceV3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.*;

class UserServiceTest {

    @Test
//    @Disabled
    @DisplayName("V2_유저서비스_DI_실패")
    void loginV2() {
        //given
        User user = new User();
        UserServiceV2 userService = new UserServiceV2();

        //when
        userService.loginV2(user);

        //then
        //Clock이 숨겨져 있는것은 동일함 -> UserService는 똑같이 테스트하기 어려움
        assertThat(user.getLastLoginTimestamp()).isEqualTo(Clock.systemUTC().millis());
    }

    @Test
    @DisplayName("V2_유저서비스_DI_DIP_성공")
    void loginV3() {
        // given
        User user = new User();
        Clock clock = Clock.fixed(Instant.parse("2000-01-01T00:00:00.00Z"), ZoneOffset.UTC);
        //테스트용 서비스 & 생성자 주입
        UserServiceV3 userService = new UserServiceV3(new TestClockHolder(clock));

        // when
        userService.loginV3(user);

        // then
        assertThat(user.getLastLoginTimestamp()).isEqualTo(946684800000L);
    }


}