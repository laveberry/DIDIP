package com.example.didip.testability.account.service;

import com.example.didip.testability.account.domain.Account;
import com.example.didip.testability.uuid.UUIDHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final UUIDHolder uuidHolder;

    public void createV2(String username, Account account) {
        account.createV2(username, uuidHolder.randomUUID());
    }
}
