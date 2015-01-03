package State;

import Game.TennisGame;
import Score.DeuceScore;
import Score.GameScore;

/**
 * Created by work on 03/01/15.
 */
public class AdvantageState implements TennisState {

    private boolean playerOneAdvantage = false;
    private boolean playerTwoAdvantage = false;

    public AdvantageState withPlayerOneAdvantage() {
        playerOneAdvantage = true;
        return this;
    }

    public AdvantageState withPlayerTwoAdvantage() {
        playerTwoAdvantage = true;
        return this;
    }

    @Override
    public void playerOneScored(TennisGame context) {

        if (!playerOneAdvantage && !playerTwoAdvantage) {
            throw new RuntimeException("Invalid advantage state");
        }

        if (playerOneAdvantage) {
            context.setPlayerOneScore(new GameScore());
            context.setState(new GameState());
        } else {
            context.setPlayerOneScore(new DeuceScore());
            context.setPlayerTwoScore(new DeuceScore());
            context.setState(new DeuceState());
        }
    }

    @Override
    public void playerTwoScored(TennisGame context) {

        if (!playerOneAdvantage && !playerTwoAdvantage) {
            throw new RuntimeException("Invalid advantage state");
        }

        if (playerTwoAdvantage) {
            context.setPlayerTwoScore(new GameScore());
            context.setState(new GameState());
        } else {
            context.setPlayerOneScore(new DeuceScore());
            context.setPlayerTwoScore(new DeuceScore());
            context.setState(new DeuceState());
        }
    }

    @Override
    public boolean isWon(TennisGame context) {
        return false;
    }
}
