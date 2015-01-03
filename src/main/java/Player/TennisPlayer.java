package Player;

import Score.*;

/**
 * Created by work on 03/01/15.
 */
public class TennisPlayer implements Player {

    private String name;
    private Score score;

    public TennisPlayer() {
        this.name = "Unknown";
        this.score = new NumericScore();
    }

    public TennisPlayer(String name) {
        this.name = name;
        this.score = new NumericScore();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public Score getScore() {
        return score;
    }
}
