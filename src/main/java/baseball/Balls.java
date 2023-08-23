package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    public static int length = 3;
    private final List<Ball> balls;

    public static Balls of(List<Integer> integers) {
        return new Balls(integers);
    }

    public Balls(List<Integer> integers) {
        validLength(integers);
        this.balls = mapBall(integers);
    }

    private void validLength(List<Integer> integers) {
        if(integers.size() != length) {
            throw new IllegalArgumentException("숫자는 "+length+"자리여야합니다.");
        }
    }

    private static List<Ball> mapBall(List<Integer> integers) {
        return IntStream.range(0, length)
                .mapToObj(i -> new Ball(i + 1, integers.get(i)))
                .collect(Collectors.toList());
    }

    public GameResult play(Balls userBalls) {
        GameResult gameResult = new GameResult();
        for (Ball ball : userBalls.balls) {
            BallState ballState = this.play(ball);
            gameResult.plusCountByBallState(ballState);
        }
        return gameResult;
    }

    public BallState play(Ball ball) {
        return balls.stream()
                .map(answer -> answer.play(ball))
                .filter(ballState -> ballState.isNotNothing())
                .findFirst()
                .orElse(BallState.NOTHING);
    }
}
