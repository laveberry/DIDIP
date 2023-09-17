package com.example.didip.account.domain;

import com.example.didip.testability.account.domain.Account;
import com.example.didip.testability.uuid.MockUUIDHolder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.powermock.api.mockito.PowerMockito.*;

class AccountTest {

    //Testability 낮은사례 - [input&output - 감춰진 의존성] - 호출자는 모르는 입력 존재
    @Test
    @DisplayName("V1_계좌생성_실패")
    void V1_계좌생성() {
        // given
        String username = "foobar";

        // when
        Account account = Account.createV1(username);

        // then
        assertThat(account.getUsername()).isEqualTo("foobar");
        /*
        authToken 의 존재를 알 수 없으니 설계부터 객체지향 캡슐화 깨진상태
        authToken 가 내부에서 생성되므로 테스트코드로 비교할 수 없음
        * */
        assertThat(account.getAuthToken()).isEqualTo("???");
    }

    @Test
    @DisplayName("V1_강제라이브러리이용_지정된UUID내려줌_실패")
    void V1_계좌생성_UUID지정() {
        // given
        String username = "foobar";
        String expectedAuthToken = "550e8400-e29b-41d4-a716-446655440000";
        // PowerMockito을 사용하여 지정된 UUID 세팅
        mockStatic(UUID.class);
        when(UUID.randomUUID()).thenReturn(UUID.fromString(expectedAuthToken));

        // when
        Account account = Account.createV1(username);

        //then
        assertThat(account.getUsername()).isEqualTo("foober");
        //UUID가 final 클래스라 stub을 지원할 수 없어 실패함
        assertThat(account.getAuthToken()).isEqualTo(expectedAuthToken);
    }

    @Test
    @DisplayName("내맘대로 테스트")
    void V2_계좌생성_UUID() {
        // given
        String username = "테스터";
        String uuid = new MockUUIDHolder(UUID.randomUUID().toString()).randomUUID();

        // when
        Account account = Account.createV2(username, uuid);

        //then
        assertThat(account.getUsername()).isEqualTo("테스터");
        assertThat(account.getAuthToken()).isEqualTo(uuid);
    }

}