package com.example.didip.testability.account.service;

import com.example.didip.testability.account.domain.Account;
import com.example.didip.testability.uuid.MockUUIDHolder;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class AccountServiceTest {

    @Test
    void createV2() {
        // given
        String username = "테스터";
        String uuid = UUID.randomUUID().toString();
        AccountService accountService = new AccountService(new MockUUIDHolder(uuid));
        Account account = Account.createV2(username, uuid);

        // when
        accountService.createV2(username, account);

        // then
        assertThat(account.getUsername()).isEqualTo("테스터");
        assertThat(account.getAuthToken()).isEqualTo(uuid);
    }
}