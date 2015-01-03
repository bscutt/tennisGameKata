package State;

import Game.TennisGame;

/**
 * Created by work on 03/01/15.
 */
public class GameState implements TennisState {

    @Override
    public void playerOneScored(TennisGame context) {
        throw new RuntimeException("Game is over");
    }

    @Override
    public void playerTwoScored(TennisGame context) {
        throw new RuntimeException("Game is over");
    }

    @Override
    public boolean isWon(TennisGame context) {
        return true;
    }
}
