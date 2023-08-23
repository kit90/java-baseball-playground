package study.baseball;

import baseball.Balls;
import baseball.BaseballGame;
import baseball.GameInput;
import baseball.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class GameResultTest{
    private Balls computerBalls;

    @BeforeEach
    void init() {
        computerBalls = new Balls(Arrays.asList(1,2,3));
    }

    @ParameterizedTest
    @MethodSource("countArgs")
    void countStrikeAndBallTest(String inputValue, int strikeCount, int ballCount) {
        List<Integer> playerNumbers = GameInput.getPlayerNumbers(inputValue);
        Balls userBalls = Balls.of(playerNumbers);
        //when
        GameResult result = computerBalls.play(userBalls);
        //then
        assertAll("countTest",
                () -> assertThat(result.getStrikeCount()).isEqualTo(strikeCount),
                () -> assertThat(result.getBallCount()).isEqualTo(ballCount)
        );
    }

    static Stream<Arguments> countArgs() {
        return Stream.of(
                Arguments.arguments("987", 0, 0),
                Arguments.arguments("198", 1, 0),
                Arguments.arguments("128", 2, 0),
                Arguments.arguments("123", 3, 0),
                Arguments.arguments("981", 0, 1),
                Arguments.arguments("912", 0, 2),
                Arguments.arguments("312", 0, 3),
                Arguments.arguments("913", 1, 1),
                Arguments.arguments("321", 1, 2)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"987:true", "654:true ",
            "123:false", "193:false", "929:false",
            "321:false", "298:false"},
            delimiter = ':')
    void isNothingTest(String inputValue, boolean expected) {
        List<Integer> playerNumbers = GameInput.getPlayerNumbers(inputValue);
        Balls userBalls = Balls.of(playerNumbers);
        //when
        GameResult result = computerBalls.play(userBalls);
        //then
        assertThat(result.isNothing()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:true",
            "987:false", "654:false ",
            "193:false", "728:false", "321:false", "298:false"},
            delimiter = ':')
    void isAllStrike(String inputValue, boolean expected) {
        List<Integer> playerNumbers = GameInput.getPlayerNumbers(inputValue);
        Balls userBalls = Balls.of(playerNumbers);
        //when
        GameResult result = computerBalls.play(userBalls);
        //then
        assertThat(result.isAllStrike()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"},
            delimiter = ':')
    void shouldReplayGame(String inputOption, boolean expected) {
        //given
        BaseballGame game = BaseballGame.makeGame();
        //when
        boolean replay = game.shouldPlayAgain(inputOption);
        //then
        assertThat(replay).isEqualTo(expected);
    }
}
