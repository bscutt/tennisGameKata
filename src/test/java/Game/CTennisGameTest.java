package Game;

import Player.TennisPlayer;
import State.NormalState;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by work on 03/01/15.
 */
public class CTennisGameTest {
    @Test
    public void testCanCreateNewGame () {
        TennisGame game = new CTennisGame(new TennisPlayer(), new TennisPlayer());
        assertNotNull("New game is not null", game);
    }

    @Test
    public void testCreateNewGamePlayerOneScoreIsZero () {
        TennisGame game = new CTennisGame(new TennisPlayer(), new TennisPlayer());
        assertEquals("Player one score is '0'", "0", game.getPlayerOneScore().toString());
    }

    @Test
    public void testPlayerOneScoresAndScoreIs15 () {
        TennisGame game = new CTennisGame(new TennisPlayer(), new TennisPlayer());
        game.setState(new NormalState());
        game.playerOneScored();
        assertEquals("Player one score is '15'", "15", game.getPlayerOneScore().toString());
    }

    @Test
    public void testPlayerTwoScoresAndScoreIs15 () {
        TennisGame game = new CTennisGame(new TennisPlayer(), new TennisPlayer());
        game.setState(new NormalState());
        game.playerTwoScored();
        assertEquals("Player one score is '15'", "15", game.getPlayerTwoScore().toString());
    }

    @Test
    public void testPlayerOneScoresTwiceAndScoreIs30 () {
        TennisGame game = new CTennisGame(new TennisPlayer(), new TennisPlayer());
        game.setState(new NormalState());
        game.playerOneScored();
        game.playerOneScored();
        assertEquals("Player one score is '30'", "30", game.getPlayerOneScore().toString());
    }

    @Test
    public void testPlayerOneScoresThreeTimesAndScoreIs40 () {
        TennisGame game = new CTennisGame(new TennisPlayer(), new TennisPlayer());
        game.setState(new NormalState());
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        assertEquals("Player one score is '40'", "40", game.getPlayerOneScore().toString());
    }

    @Test
    public void testPlayerOneScoresFourTimesAndWins () {
        TennisGame game = new CTennisGame(new TennisPlayer("Player 1"), new TennisPlayer("Player 2"));
        game.setState(new NormalState());
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        assertEquals("Player one score is 'Game'", "Game", game.getPlayerOneScore().toString());
        assertEquals("Winner name is 'Player 1'", "Player 1", game.getWinner().getName());
    }

    @Test
    public void testPlayerOneAndThenTwoScoreThreeTimesScoreIsDeuce () {
        TennisGame game = new CTennisGame(new TennisPlayer("Player 1"), new TennisPlayer("Player 2"));
        game.setState(new NormalState());
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
        assertEquals("Player one score is 'Deuce'", "Deuce", game.getPlayerOneScore().toString());
        assertEquals("Player two score is 'Deuce'", "Deuce", game.getPlayerTwoScore().toString());
    }

    @Test
    public void testPlayerTwoAndThenOneScoreThreeTimesScoreIsDeuce () {
        TennisGame game = new CTennisGame(new TennisPlayer("Player 1"), new TennisPlayer("Player 2"));
        game.setState(new NormalState());
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        assertEquals("Player two score is 'Deuce'", "Deuce", game.getPlayerTwoScore().toString());
        assertEquals("Player one score is 'Deuce'", "Deuce", game.getPlayerOneScore().toString());
    }

    @Test
    public void testDeuceScoreThenPlayerOneScoresScoreIsAdvantage () {
        TennisGame game = new CTennisGame(new TennisPlayer("Player 1"), new TennisPlayer("Player 2"));
        game.setState(new NormalState());
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerOneScored();
        assertEquals("Player one score is 'Advantage In'", "Advantage In", game.getPlayerOneScore().toString());
        assertEquals("Player two score is 'Advantage Out'", "Advantage Out", game.getPlayerTwoScore().toString());
    }

    @Test
    public void testDeuceScoreThenPlayerTwoScoresScoreIsAdvantage () {
        TennisGame game = new CTennisGame(new TennisPlayer("Player 1"), new TennisPlayer("Player 2"));
        game.setState(new NormalState());
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
        assertEquals("Player two score is 'Advantage In'", "Advantage In", game.getPlayerTwoScore().toString());
        assertEquals("Player one score is 'Advantage Out'", "Advantage Out", game.getPlayerOneScore().toString());
    }

    @Test
    public void testDeuceScoreThenPlayerOneScoresTwiceScoreIsGame () {
        TennisGame game = new CTennisGame(new TennisPlayer("Player 1"), new TennisPlayer("Player 2"));
        game.setState(new NormalState());
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerOneScored();
        game.playerOneScored();
        assertEquals("Player one score is 'Game'", "Game", game.getPlayerOneScore().toString());
        assertEquals("Winner name is 'Player 1'", "Player 1", game.getWinner().getName());
    }

    @Test
    public void testDeuceScoreThenPlayerTwoScoresTwiceScoreIsGame () {
        TennisGame game = new CTennisGame(new TennisPlayer("Player 1"), new TennisPlayer("Player 2"));
        game.setState(new NormalState());
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
        assertEquals("Player two score is 'Game'", "Game", game.getPlayerTwoScore().toString());
        assertEquals("Winner name is 'Player 2'", "Player 2", game.getWinner().getName());
    }

    @Test
    public void testDeuceScoreThenPlayerOneScoresThenPlayerTwoScoreIsDeuce () {
        TennisGame game = new CTennisGame(new TennisPlayer("Player 1"), new TennisPlayer("Player 2"));
        game.setState(new NormalState());
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerOneScored();
        game.playerTwoScored();
        assertEquals("Player two score is 'Deuce'", "Deuce", game.getPlayerTwoScore().toString());
        assertEquals("Player one score is 'Deuce'", "Deuce", game.getPlayerOneScore().toString());
    }
}
