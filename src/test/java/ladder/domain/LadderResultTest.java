package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DisplayName("사다리 결과 테스트")
class LadderResultTest {

    LadderResult ladderResult;

    @BeforeEach
    void init() {
        Participants participants = new Participants("aaa, bbb");
        List<UserName> userNames = participants.fetchNames();
        Reward reward1 = new Reward("3000");
        Reward reward2 = new Reward("꽝");
        Map<UserName, Reward> ladderResultMap = new HashMap<>();
        ladderResultMap.put(userNames.get(0), reward1);
        ladderResultMap.put(userNames.get(1), reward2);
        ladderResult = new LadderResult(ladderResultMap);
    }
    @DisplayName("참여자의 목록을 조회 할 수 있다")
    @Test
    void UsersNameTest() {
        List<UserName> userNameList = ladderResult.fetchUsers();

        Assertions.assertThat(userNameList.get(0).fetchName()).isEqualTo("aaa");
        Assertions.assertThat(userNameList.get(1).fetchName()).isEqualTo("bbb");
        Assertions.assertThat(userNameList)
                .containsExactly(
                        new UserName("aaa"),
                        new UserName("bbb"));
    }

    @DisplayName("참여자의 당첨 상품을 확인 할 수 있다")
    @Test
    void rewardsOfUsersTest() {
        Reward reward = ladderResult.rewardOfUser("aaa");
        String rewardName = reward.fetchReward();
        Assertions.assertThat(rewardName).isEqualTo("3000");
    }
}
