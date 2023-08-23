package study.inClass;

import inClass.Ball;
import inClass.BallState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball com;

    @BeforeEach
    void setUP() { //중복 부분 given
        com = new Ball(1, 4);
    }

    @Test
    void strike() {
        //output <- input
        BallState status = com.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallState.STRIKE);
    }

    @Test
    void ball() {
        //output <- input
        BallState status = com.play(new Ball(2, 4));
        assertThat(status).isEqualTo(BallState.BALL);
    }

    @Test
    void nothing() {
        //output <- input
        BallState status = com.play(new Ball(2, 5));
        assertThat(status).isEqualTo(BallState.NOTHING);
    }
}
