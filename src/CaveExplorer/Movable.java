package CaveExplorer;

/**
 * Represents any object that can move around rooms.
 */
public interface Movable {
    Room getCurrentRoom();
    void setCurrentRoom(Room currentRoom);
    String move(Direction direction);
}
