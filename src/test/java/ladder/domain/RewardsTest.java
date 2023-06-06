package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("경품들 객체 테스트")
class RewardsTest {

    @DisplayName("참여자의 수 와 경품 수가 같지 않으면 예외가 발생한다")
    @Test
    void createRewardsWithException() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Rewards.createRewards("꽝, 3000, 꽝", 4))
                .withMessage("참여자의 수와 경품 수가 같아야합니다");

    }
    @DisplayName("참여자의 수와 경품수가 같으면 경품들 객체가 생성된다")
    @Test
    void createRewards() {
        Rewards rewards = Rewards.createRewards("꽝, 5000, 꽝, 3000, 꽝", 5);

        Assertions.assertThat(rewards.fetchLadderRewards())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly(
                        new Reward(rewards.rewardByIndex(0).fetchReward()),
                        new Reward(rewards.rewardByIndex(1).fetchReward()),
                        new Reward(rewards.rewardByIndex(2).fetchReward()),
                        new Reward(rewards.rewardByIndex(3).fetchReward()),
                        new Reward(rewards.rewardByIndex(4).fetchReward()));

    }
}
