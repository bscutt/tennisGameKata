package Score;

/**
 * Created by work on 03/01/15.
 */
public class AdvantageInScore implements Score{
    @Override
    public Score increment() {
        throw new RuntimeException("Advantage cannot be incremented");
    }

    @Override
    public String toString() {
        return "Advantage In";
    }
}
