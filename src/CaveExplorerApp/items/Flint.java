package CaveExplorerApp.items;

import CaveExplorerApp.globals.Usable;

public class Flint extends Item implements Usable {
    public Flint(String name, String description, boolean isConsumedOnUse) {
        super(name, description, isConsumedOnUse);
    }

    @Override
    public String use() {
        return "You are using flint to start a fire. ";
    }
}
