package com.example.didip.testability.uuid;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SystemUUIDHolder implements UUIDHolder{
    @Override
    public String randomUUID() {
        return UUID.randomUUID().toString();
    }
}
