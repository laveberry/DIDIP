package com.example.didip.login.service;

import com.example.didip.login.domain.User;
import org.springframework.stereotype.Service;

import java.time.Clock;

@Service
public class UserServiceV2 {

    public void loginV2(User user) {
        //Clock이 숨겨져 있는것은 동일함 -> UserService는 똑같이 테스트하기 어려움
        user.loginV2(Clock.systemUTC());
    }

}
