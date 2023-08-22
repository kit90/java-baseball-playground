package baseball;

import java.util.Objects;

public class Ball {
    private final int position;
    private final BallNumber number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = BallNumber.of(number);
    }

    public BallState play(Ball ball) {
        if(this.equals(ball)) {
            return BallState.STRIKE;
        }
        if(this.isEqualNumber(ball.number.getNo())){
            return BallState.BALL;
        }
        return BallState.NOTHING;
    }

    boolean isEqualNumber(int number) {
        return this.number.getNo() == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number.getNo() == ball.number.getNo();
    }

    public int getPosition() {
        return position;
    }
    public BallNumber getNumber() {
        return number;
    }
}
