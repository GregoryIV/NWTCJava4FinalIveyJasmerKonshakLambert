package CaveExplorerApp.items;

import CaveExplorerApp.globals.Usable;

public class Flashlight extends Item implements Usable {

    private boolean isOn;
    private boolean hasBattery;
    private Battery battery;

    public Flashlight(String name, String description, Boolean isOn, boolean hasBattery , boolean isConsumedOnUse) {
        super(name, description, isConsumedOnUse);
        this.isOn = isOn;
        this.hasBattery = hasBattery;
    }

    @Override
    public String use() {
        String returnString;

        if (hasBattery) {
            isOn = !isOn;
            returnString = ((isOn) ?
                    "You turned the flashlight on" :
                    "You turned the flashlight off");
        } else {
            returnString = "The flashlight is out of batteries";
        }
        return returnString;
    }

    public boolean hasBattery() {
        return (battery != null);
    }

    public void insertBattery(Battery battery) {
        hasBattery = true;
        battery = null;
    }
}
