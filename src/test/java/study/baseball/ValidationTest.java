package study.baseball;

import baseball.Balls;
import baseball.BaseballGame;
import baseball.GameInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ValidationTest {
    @ParameterizedTest
    @ValueSource(strings = {"045", "607", "890"})
    @DisplayName("입력값이_각각_1~9사이의_숫자여야한다")
    void fail_validate_number (String inputValue) {
        List<Integer> playerNumbers = GameInput.getPlayerNumbers(inputValue);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Balls.of(playerNumbers);
                }).withMessageMatching("입력은 1~9사이의 숫자여야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "23"})
    @DisplayName("입력값은_3자리_숫자여야한다")
    void fail_validate_length (String inputValue) {
        List<Integer> playerNumbers = GameInput.getPlayerNumbers(inputValue);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Balls.of(playerNumbers);
                }).withMessageMatching("숫자는 3자리여야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "232", "445", "477"})
    @DisplayName("입력된_숫자는_중복이어선_안된다")
    void fail_validate_duplication (String inputValue) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    GameInput.getPlayerNumbers(inputValue);
                }).withMessageMatching("중복된 값은 입력할 수 없습니다.");
    }


    @ParameterizedTest
    @ValueSource(strings = {"", "0", "123", "abc", "-1"})
    @DisplayName("게임_재시작/종료_입력은_1,2이_아니면_예외_발생")
    void fail_validate_InputOption (String inputOption) {
        BaseballGame game = BaseballGame.makeGame();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    game.shouldPlayAgain(inputOption);
                }).withMessageMatching("올바른 입력값이 아닙니다.");
    }
}
