package inClass;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = ballNo;
    }

    public BallState play(Ball ball) {
        if(this.equals(ball)) { //ball.equals(this)를 해도되지만, null이 넘어올 가능성 있으므로
            return BallState.STRIKE;
        }
        //if (ballNo == ball.ballNo)
        //같은 클래스내에 있긴하지만 직접 필드 호출보다는 해당하는 객체의 메서드불러서 간접적으로, 용도 확실히
        if(ball.matchBallNo(ballNo)) {
            return BallState.BALL;
        }
        return BallState.NOTHING;
    }

    private boolean matchBallNo(int ballNo) {
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }
}
