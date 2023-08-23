package baseball;

import java.util.List;
import java.util.Scanner;

public class RunGame {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean play = true;
        BaseballGame game = BaseballGame.makeGame();

        while (play) {
            Balls computerBalls = game.getComputerBalls();
            List<Integer> playerNumbers = GameInput.getPlayerNumbers(startGameRound());
            Balls userBalls = Balls.of(playerNumbers);
            GameResult result = computerBalls.play(userBalls);
            GameView.printResultView(result);
            if (result.isAllStrike()) {
                play = game.shouldPlayAgain(endGameRound());
            }
        }

    }

    private static String startGameRound() {
        System.out.print("숫자를 입력해 주세요:");
        return scanner.nextLine();
    }

    private static String endGameRound() {
        System.out.println("축하합니다! 경기를 다시 시작하겠습니까? 다시 시작 : 1, 종료 : 2");
        return scanner.nextLine();
    }

}
