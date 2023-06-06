package ladder.domain;

public class Reward {

    public static final String NO_REWARD = "꽝";

    private static final String NUMBER_REGEX = "^[0-9]*$";
    private final String ladderReward;

    public Reward(String ladderReward) {
        validateLadderReward(ladderReward);
        this.ladderReward = ladderReward;
    }

    private void validateLadderReward(String ladderReward) {
        if (!isLadderReward(ladderReward)) {
            throw new IllegalArgumentException("로또 보상은 금액 또는 꽝 입력만 가능합니다");
        }
    }

    private static boolean isLadderReward(String ladderReward) {
        return ladderReward.equals(NO_REWARD) || ladderReward.matches(NUMBER_REGEX);
    }

    public String fetchReward() {
        return ladderReward;
    }
}
