package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("이름 테스트")
class UserNameTest {

    @DisplayName("이름은 5글자를 초과 할 수 없다")
    @Test
    void nameLengthTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserName("abcdef"))
                .withMessage("이름은 5글자를 초과 할 수 없습니다");
    }

    @ParameterizedTest(name = "5글자 이내의 이름은 정상적으로 생성된다")
    @ValueSource(strings = {"a", "bb", "ccc", "dddd"})
    void nameCreateTest(String inputName) {
        UserName userName = new UserName(inputName);
        assertThat(userName.fetchName()).isEqualTo(inputName);
    }

    @ParameterizedTest(name = "이름의 길이를 구할 수 있다")
    @CsvSource(value = {"a:1", "bb:2", "ccc:3", "dddd:4", "eeeee:5"}, delimiter = ':')
    void calculateNameLength(String name, int expectedNameLength) {
        UserName userName = new UserName(name);
        int actualNameLength = userName.calculateNameLength();
        assertThat(actualNameLength).isEqualTo(expectedNameLength);
    }

    @DisplayName(value = "참여 이름은 주어진 크기에 맞게 중앙 정렬 할수 있다")
    @Test
    void centerAlignName() {
        UserName userName = new UserName("woos");
        String alignedName = userName.centerAlignName(10);
        assertEquals("   woos   ", alignedName);
    }
}
