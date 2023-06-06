package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static ladder.domain.Reward.NO_REWARD;

@DisplayName("로또 상품 테스트")
class RewardTest {

    @ParameterizedTest(name = "로또 보상은 금액 또는 꽝이 아니면 예외가 발생한다")
    @ValueSource(strings = {"마음♥", "자동차", "-1000"})
    void ladderRewardFail(String reward) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Reward(reward))
                .withMessage("로또 보상은 금액 또는 꽝 입력만 가능합니다");
    }

    @ParameterizedTest(name = "금액 또는 꽝을 입력하면 로또 보상이 생성된다")
    @ValueSource(strings = {"77", "50000", NO_REWARD})
    void ladderRewardSuccess(String input) {
        Reward reward = new Reward(input);
        Assertions.assertThat(reward.fetchReward()).isEqualTo(input);
    }
}
