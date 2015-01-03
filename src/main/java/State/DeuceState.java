package State;

import Game.TennisGame;
import Score.AdvantageInScore;
import Score.AdvantageOutScore;

/**
 * Created by work on 03/01/15.
 */
public class DeuceState implements TennisState {

    @Override
    public void playerOneScored(TennisGame context) {
        context.setPlayerOneScore(new AdvantageInScore());
        context.setPlayerTwoScore(new AdvantageOutScore());
        context.setState(new AdvantageState().withPlayerOneAdvantage());
    }

    @Override
    public void playerTwoScored(TennisGame context) {
        context.setPlayerOneScore(new AdvantageOutScore());
        context.setPlayerTwoScore(new AdvantageInScore());
        context.setState(new AdvantageState().withPlayerTwoAdvantage());
    }

    @Override
    public boolean isWon(TennisGame context) {
        return false;
    }
}
