package State;

import Game.TennisGame;
import Score.DeuceScore;
import Score.GameScore;

/**
 * Created by work on 03/01/15.
 */
public class NormalState implements TennisState {

    @Override
    public void playerOneScored(TennisGame context) {

        if (context.getPlayerTwoScore().toString().equals("40") &&
                context.getPlayerOneScore().toString().equals("30")) {
            context.setPlayerOneScore(new DeuceScore());
            context.setPlayerTwoScore(new DeuceScore());
            context.setState(new DeuceState());
        } else if (context.getPlayerOneScore().toString().equals("40")) {
            context.setPlayerOneScore(new GameScore());
            context.setState(new GameState());
        } else {
            context.setPlayerOneScore(context.getPlayerOneScore().increment());
        }
    }

    @Override
    public void playerTwoScored(TennisGame context) {

        if (context.getPlayerOneScore().toString().equals("40") &&
                context.getPlayerTwoScore().toString().equals("30")) {
            context.setPlayerOneScore(new DeuceScore());
            context.setPlayerTwoScore(new DeuceScore());
            context.setState(new DeuceState());
        } else if (context.getPlayerTwoScore().toString().equals("40")) {
            context.setPlayerTwoScore(new GameScore());
            context.setState(new GameState());
        } else {
            context.setPlayerTwoScore(context.getPlayerTwoScore().increment());
        }
    }

    @Override
    public boolean isWon(TennisGame context) {
        return false;
    }
}
