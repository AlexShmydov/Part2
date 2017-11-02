package Objects;

public abstract class BaseStudent {
    private int id = 0;
    private static int instanceCounter = 0;

    public int getId() {
        return id;
    }

    public BaseStudent() {
        id = instanceCounter;
        instanceCounter++;
    }
}
