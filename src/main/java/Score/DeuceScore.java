package Score;

/**
 * Created by work on 03/01/15.
 */
public class DeuceScore implements Score {

    @Override
    public Score increment() {
        throw new RuntimeException("Deuce cannot be incremented");
    }

    @Override
    public String toString() {
        return "Deuce";
    }
}
