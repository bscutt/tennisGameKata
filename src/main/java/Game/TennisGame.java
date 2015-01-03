package Game;

import Score.Score;
import State.TennisState;
import Player.Player;

/**
 * Created by work on 03/01/15.
 */
public interface TennisGame {
    public void setState(TennisState state);
    public void playerOneScored();
    public void playerTwoScored();
    public Score getPlayerOneScore();
    public void setPlayerOneScore(Score score);
    public Score getPlayerTwoScore();
    public void setPlayerTwoScore(Score score);
    public Player getWinner();
}
