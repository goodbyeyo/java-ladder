package ladder.domain;

import java.util.Objects;

public class UserName {
    public static final int MAX_LENGTH_USER_NAME = 5;

    public static final String EMPTY_SPACE = " ";
    private final String name;

    public UserName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH_USER_NAME) {
            throw new IllegalArgumentException(String.format("이름은 %d글자를 초과 할 수 없습니다", MAX_LENGTH_USER_NAME));
        }
    }

    public String centerAlignName(int maxOutputNameLength) {
        int leftPadding = (maxOutputNameLength - name.length()) / 2;
        int rightPadding = maxOutputNameLength - leftPadding - name.length();
        return String.format("%s%s%s", EMPTY_SPACE.repeat(leftPadding), name, EMPTY_SPACE.repeat(rightPadding));
    }

    public int calculateNameLength() {
        return name.length();
    }

    public String fetchName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
