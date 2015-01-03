package Game;

import Score.*;
import Player.Player;
import State.TennisState;

/**
 * Created by work on 03/01/15.
 */
public class CTennisGame implements TennisGame {

    private Player playerOne;
    private Player playerTwo;
    private TennisState state;

    public CTennisGame(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    @Override
    public void setState(TennisState state) {
        this.state = state;
    }

    @Override
    public void playerOneScored() {
        state.playerOneScored(this);
    }

    @Override
    public void playerTwoScored() {
        state.playerTwoScored(this);
    }

    @Override
    public Score getPlayerOneScore() {
        return playerOne.getScore();
    }

    @Override
    public void setPlayerOneScore(Score score) {
        playerOne.setScore(score);
    }

    @Override
    public Score getPlayerTwoScore() {
        return playerTwo.getScore();
    }

    @Override
    public void setPlayerTwoScore(Score score) {
        playerTwo.setScore(score);
    }

    @Override
    public Player getWinner() {

        if (!state.isWon(this)) {
            throw new RuntimeException("Game still in progress");
        }

        if (playerOne.getScore().toString().equals("Game")) {
            return playerOne;
        }

        if (playerTwo.getScore().toString().equals("Game")) {
            return playerTwo;
        }

        return null;
    }
}
