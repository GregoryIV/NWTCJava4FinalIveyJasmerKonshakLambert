package CaveExplorer.globals;

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
     * 
     * @param direction
     * @return
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

