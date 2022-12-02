package CaveExplorer.globals;

public enum Direction {
    North,
    South,
    East,
    West;

    public static Direction findByString(String test) {

        for (Direction d : Direction.values()) {
            if (d.name().toLowerCase().equals(test)) {
                return d;
            }
        }

        return null;
    }
}

