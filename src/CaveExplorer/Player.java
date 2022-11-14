package CaveExplorer;

import java.util.ArrayList;

public class Player extends GameObject{

    private Room location;
    private ArrayList<Item> inventory;
    public Player(String name, String description, Room location, ArrayList<Item> inventory) {
        super(name, description);
        this.location = location;
        this.inventory = inventory;
    }
    public String look(GameObject gameObject) {
        return gameObject.getDescription();
    }
}
