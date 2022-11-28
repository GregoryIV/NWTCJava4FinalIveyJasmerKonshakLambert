package CaveExplorer.items;

import CaveExplorer.Usable;
import CaveExplorer.Item;
public class Dynamite extends Item implements Usable {

    public Dynamite(String name, String description, boolean isConsumedOnUse) {
        super(name, description, isConsumedOnUse);
    }

    @Override
    public String use() {
        return "You blow stuff up";
    }
}
