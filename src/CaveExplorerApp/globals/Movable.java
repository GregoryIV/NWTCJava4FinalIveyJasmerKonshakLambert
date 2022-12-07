package CaveExplorerApp.globals;

import CaveExplorerApp.Room;

/**
 * An object that can move around rooms
 */
public interface Movable {
    public String move(Direction direction);
    public Room getCurrentRoom();

}
