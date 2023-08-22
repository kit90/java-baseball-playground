package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    public final static int length = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> integers) {
        this.balls = mapBall(integers);
    }

    private static List<Ball> mapBall(List<Integer> integers) {
        return IntStream.range(0, length)
                .mapToObj(i -> new Ball(i + 1, integers.get(i)))
                .collect(Collectors.toList());
    }

    public BallState play(Ball ball) {
       /* BallState result = BallState.NOTHING;
        for (Ball answer : balls) {
            result = answer.play(ball);
            if(result.isNotNothing())
               return result;
        }
        return result;*/
        return balls.stream()
                .map(answer -> answer.play(ball))
                .filter(ballState -> ballState.isNotNothing())
                .findFirst()
                .orElse(BallState.NOTHING);
    }

    public PlayResult play(Balls userBalls) {
        PlayResult playResult = new PlayResult();
        for (Ball ball : userBalls.balls) {
            BallState ballState = this.play(ball);
            playResult.plusCountByBallState(ballState);
        }
        return playResult;
    }
}
