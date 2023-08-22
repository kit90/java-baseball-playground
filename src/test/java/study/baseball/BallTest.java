package study.baseball;

import baseball.Ball;

import baseball.BallState;
import baseball.Balls;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {
    private Ball computerBall;

    @BeforeEach
    void init() {
        computerBall = new Ball(1, 4);
    }

    @Test
    void strike() {
        BallState status = computerBall.play(new Ball(1, 4));
        Assertions.assertThat(status).isEqualTo(BallState.STRIKE);
    }

    @Test
    void ball() {
        BallState status = computerBall.play(new Ball(2, 4));
        Assertions.assertThat(status).isEqualTo(BallState.BALL);
    }

    @Test
    void nothing() {
        BallState status = computerBall.play(new Ball(1, 2));
        Assertions.assertThat(status).isEqualTo(BallState.NOTHING);
    }

}
