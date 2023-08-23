package baseball;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseballGame {
    private Balls computerBalls;

    private BaseballGame() {
        this.computerBalls = BallsGenerator.generateComputerBalls();
    }

    public static BaseballGame makeGame() {
        return new BaseballGame();
    }

    public boolean shouldPlayAgain(String input) {
        validateInputGameOption(input);
        boolean again = isPlayAgain(input);
        if(again) {
            resetComputerBalls();
        }
        return again;
    }

    private void validateInputGameOption(String input) {
        Pattern pattern = Pattern.compile("^[1-2]$");
        Matcher matcher = pattern.matcher(input);
        if(!matcher.find()) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
    }

    private boolean isPlayAgain(String input) {
        char answer = input.charAt(0);
        if(answer == '1') {
            return true;
        }
        return false;
    }


    private void resetComputerBalls() {
        this.computerBalls = BallsGenerator.generateComputerBalls();
    }

    public Balls getComputerBalls() {
        return computerBalls;
    }
}
