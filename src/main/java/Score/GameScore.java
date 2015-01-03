package Score;

/**
 * Created by work on 03/01/15.
 */
public class GameScore implements Score {

    @Override
    public Score increment() {
        throw new RuntimeException("Game cannot be incremented");
    }

    @Override
    public String toString() {
        return "Game";
    }
}
