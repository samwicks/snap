package snap;

import java.util.concurrent.ThreadLocalRandom;

public class Player {
    private final String name;

    public Player (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int think() {
        return ThreadLocalRandom.current().nextInt(1000, 2500);
    }

    public String toString() {
        return String.format("Player[%s]", getName());
    }

}
