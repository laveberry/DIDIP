package com.example.didip.testability.uuid;

//test코드는 생성자 생성이 포인트
public class MockUUIDHolder implements UUIDHolder{
    private String uuidString;

    public MockUUIDHolder(String uuidString) {
        this.uuidString = uuidString;
    }

    @Override
    public String randomUUID() {
        return uuidString;
    }
}
