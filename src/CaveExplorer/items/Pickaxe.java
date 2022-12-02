package CaveExplorer.items;

import CaveExplorer.globals.Usable;

public class Pickaxe extends Item implements Usable {

    public Pickaxe(String name, String description, boolean isConsumedOnUse) {
        super(name, description, isConsumedOnUse);
    }

    @Override
    public String use() {
        return "You swing the pickaxe";
    }
}
