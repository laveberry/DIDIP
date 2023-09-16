package com.example.didip.clock;

import org.springframework.stereotype.Component;

import java.time.Clock;

// 스프링 빈 등록을 통해, 실제 배포환경에서 사용
@Component
public class SystemClockHolder implements ClockHolder{
    @Override
    public long getMillis() {
        return Clock.systemUTC().millis();
    }
}
