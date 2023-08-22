package study.baseball;

import baseball.Ball;
import baseball.BallState;
import baseball.Balls;
import baseball.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    private Balls computerBalls;

    @BeforeEach
    void init() {
        computerBalls = new Balls(Arrays.asList(1,2,3));
    }

    @Test
    void strike3() {
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        GameResult result = computerBalls.play(userBalls);
        assertThat(result.getStrikeCount()).isEqualTo(3);
    }

    @Test
    void strike1_ball1() {
        Balls userBalls = new Balls(Arrays.asList(3, 2, 4));
        GameResult result = computerBalls.play(userBalls);
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(1);
    }

    @Test
    void strike() {
        BallState status = computerBalls.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallState.STRIKE);
    }

    @Test
    void ball() {
        BallState status = computerBalls.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BallState.BALL);
    }

    @Test
    void nothing() {
        BallState status = computerBalls.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallState.NOTHING);
    }
}
