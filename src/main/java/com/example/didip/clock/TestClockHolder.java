package com.example.didip.clock;

import lombok.AllArgsConstructor;

import java.time.Clock;

@AllArgsConstructor
public class TestClockHolder implements ClockHolder{

    private Clock clock;

    @Override
    public long getMillis() {
        return clock.millis();
    }
}
