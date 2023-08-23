package baseball;

public class BallNumber {
    public static final int MAX_NO= 9;
    public static final int MIN_NO = 1;
    private int no;

    public static BallNumber of(int no) {
        return new BallNumber(no);
    }

    private BallNumber(int no){
        validNo(no);
        this.no = no;
    }

    private void validNo(int no) {
        if(no < MIN_NO || no > MAX_NO) {
            throw new IllegalArgumentException("입력은 1~9사이의 숫자여야합니다.");
        }
    }

    public int getNo() {
        return no;
    }
}
