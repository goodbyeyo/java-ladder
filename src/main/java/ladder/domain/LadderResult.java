package ladder.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {

    private final Map<UserName, Reward> rewardsOfUsers;

    public LadderResult(Map<UserName, Reward> rewardsOfUsers) {
        this.rewardsOfUsers = rewardsOfUsers;
    }

    public List<UserName> fetchUsers() {
        return rewardsOfUsers.keySet()
                .stream()
                .sorted(Comparator.comparing(UserName::fetchName))
                .collect(Collectors.toList());
    }

    public Reward rewardOfUser(String userName) {
        return rewardsOfUsers.get(new UserName(userName));
    }
}
