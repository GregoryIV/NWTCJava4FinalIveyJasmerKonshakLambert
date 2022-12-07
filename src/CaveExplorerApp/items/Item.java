package CaveExplorerApp.items;

import CaveExplorerApp.globals.GameObject;

public abstract class Item extends GameObject {
    private boolean isConsumedOnUse;
    public Item(String name, String description, boolean isConsumedOnUse) {
        super(name, description);
        this.isConsumedOnUse = isConsumedOnUse;
    }

    public boolean isConsumedOnUse() {
        return isConsumedOnUse;
    }

    @Override
    public String toString() {
        return getName();
    }
}
