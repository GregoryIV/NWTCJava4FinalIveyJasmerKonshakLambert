package CaveExplorerApp.globals;

/**
 * A direction
 * 1.8 Use of enumerations.
 */
public enum Direction {
    North,
    South,
    East,
    West;

    /**
     * Find a direction in the enum.
     *
     * @param direction - Direction to find.
     * @return - A direction if it exists. Null if the direction doesn't exist.
     */
    public static Direction findByString(String direction) {

        for (Direction d : Direction.values()) {
            if (d.name().toLowerCase().equals(direction)) {
                return d;
            }
        }

        return null;
    }
}

