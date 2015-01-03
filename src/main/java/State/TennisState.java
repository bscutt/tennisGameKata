package State;

import Game.TennisGame;

/**
 * Created by work on 03/01/15.
 */
public interface TennisState {
    public void playerOneScored(TennisGame context);
    public void playerTwoScored(TennisGame context);
    public boolean isWon(TennisGame context);
}
