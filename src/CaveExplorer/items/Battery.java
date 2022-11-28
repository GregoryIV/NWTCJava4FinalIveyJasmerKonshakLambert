package CaveExplorer.items;

import CaveExplorer.Item;
import CaveExplorer.UsableOn;
public class Battery extends Item implements UsableOn {


    public Battery(String name, String description, boolean isConsumedOnUse) {
        super(name, description, isConsumedOnUse);
    }

    @Override
    public String useOn(Item itemToUseOn) {

        if (itemToUseOn instanceof Flashlight) {
            Flashlight f = (Flashlight) itemToUseOn;
            f.insertBattery(this);
        }

        return "Used the battery on the " + itemToUseOn.getName();
    }

}
