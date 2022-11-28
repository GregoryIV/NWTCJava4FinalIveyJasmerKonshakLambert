package CaveExplorer;

public class Pickaxe extends Item{

    public Pickaxe(String name, String description) {
        super(name, description);
    }

    @Override
    public String Use() {
        return "You swing the pickaxe";
    }
}
