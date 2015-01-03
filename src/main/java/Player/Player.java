package Player;

import Score.Score;

/**
 * Created by work on 03/01/15.
 */
public interface Player {

    public void setName(String name);
    public String getName();

    public void setScore(Score score);
    public Score getScore();
}
