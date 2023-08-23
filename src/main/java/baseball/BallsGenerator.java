package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BallsGenerator {
    public static Balls generateComputerBalls() {
        List<Integer> randomNumbers = IntStream.range(0, Balls.length)
                .mapToObj(i -> (int) (Math.random() * 9) + 1) // 1부터 9까지의 숫자
                .collect(Collectors.toList());
        return Balls.of(randomNumbers);
    }
}
