package com.example.didip.login.service;

import com.example.didip.clock.ClockHolder;
import com.example.didip.login.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceV3 {

    private final ClockHolder clockHolder;

    public void loginV3(User user) {
        //의존성 역전 : user는 clock이 아닌 인터페이스 clockHolder에 의존함
        user.loginV3(clockHolder);
    }

}
