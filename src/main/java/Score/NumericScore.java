package Score;

/**
 * Created by work on 03/01/15.
 */
public class NumericScore implements Score {

    private int score;

    public NumericScore() {
        this.score = 0;
    }

    public NumericScore(int score) {
        this.score = score;
    }

    @Override
    public Score increment() {
        if (this.score < 30) {
            return new NumericScore(this.score + 15);
        } else {
            return new NumericScore(40);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.score);
    }
}
