package CaveExplorer;

public abstract class Item extends GameObject implements Useable{
    public Item(String name, String description) {
        super(name, description);
    }
}
