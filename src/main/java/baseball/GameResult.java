package baseball;

public class GameResult {
    private int ballCount = 0;
    private int strikeCount = 0;

    public GameResult() {
    }

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public void plusCountByBallState(BallState ballState) {
        if(ballState.isBall()) {
            ballCount++;
        } else if (ballState.isStrike()) {
            strikeCount++;
        }
    }

    public boolean isAllStrike() {
        return strikeCount == Balls.length;
    }
    public boolean isNothing() {
        return strikeCount + ballCount == 0;
    }

    public int getBallCount() {
        return ballCount;
    }
    public int getStrikeCount() {
        return strikeCount;
    }
}
