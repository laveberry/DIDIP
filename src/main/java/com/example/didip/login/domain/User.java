package com.example.didip.login.domain;

import com.example.didip.clock.ClockHolder;
import lombok.Getter;

import java.time.Clock;

@Getter
public class User {
    // 문제 : 사용자 로그인 할때마다 마지막 로그인 시간 기록
    private long lastLoginTimestamp;
    public void loginV1() {

        /*
        Clock에 의존적 로직
        외부에서는 login()이 시간에 의존하는지 알 수 없음
         */
        this.lastLoginTimestamp = Clock.systemUTC().millis();
    }

    public void loginV2(Clock clock) {
        this.lastLoginTimestamp = clock.millis();
    }

    public void loginV3(ClockHolder clockHolder) {
        this.lastLoginTimestamp = clockHolder.getMillis();
    }
}
