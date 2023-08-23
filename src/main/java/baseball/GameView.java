package baseball;

public class GameView {
    public static void printResultView(GameResult result) {
        String resultView = getResultView(result);
        System.out.println(resultView);
    }

    private static String getResultView(GameResult result) {
        int strikeCount = result.getStrikeCount();
        int ballCount = result.getBallCount();

        String view = "";
        if(strikeCount > 0) {
            view +=  strikeCount + "스트라이크";
        }
        if(ballCount > 0) {
            view += ballCount + "볼";
        } else if (result.isNothing()) {
            view = "낫싱";
        } else if(result.isAllStrike()) {
            view = strikeCount + "스트라이크\n";
            view += strikeCount + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        return view;
    }
}
