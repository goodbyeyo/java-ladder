package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private static final String DELIMITER = ",";
    private final List<Reward> ladderRewards;

    public Rewards(List<Reward> ladderRewards) {
        this.ladderRewards = ladderRewards;
    }

    public static Rewards createRewards(String inputLadderResult, int countOfUsers) {
        String[] rewards = inputLadderResult.split(DELIMITER);

        validateLadderRewards(rewards.length, countOfUsers);

        return new Rewards(Arrays.stream(rewards)
                .map(reward -> new Reward(reward.trim()))
                .collect(Collectors.toList()));
    }

    private static void validateLadderRewards(int countOfRewards, int countOfUsers) {
        if (countOfRewards != countOfUsers) {
            throw new IllegalArgumentException("참여자의 수와 경품 수가 같아야합니다");
        }
    }

    public List<Reward> fetchLadderRewards() {
        return Collections.unmodifiableList(ladderRewards);
    }

    public Reward rewardByIndex(int index) {
        return ladderRewards.get(index);
    }
}
