package CaveExplorer;

public class Dynamite extends Item{

    public Dynamite(String name, String description) {
        super(name, description);
    }

    @Override
    public String Use() {
        return "You blow stuff up";
    }
}
