package CaveExplorer.items;

import CaveExplorer.globals.Usable;

public class Flashlight extends Item implements Usable {

    private boolean isOn;
    private boolean hasBatteries;

    public Flashlight(String name, String description, Boolean isOn, boolean hasBatteries , boolean isConsumedOnUse) {
        super(name, description, isConsumedOnUse);
        this.isOn = isOn;
        this.hasBatteries = hasBatteries;
    }

    @Override
    public String use() {
        String returnString;

        if (hasBatteries) {
            isOn = !isOn;
            returnString = ((isOn) ?
                    "You turned the flashlight on" :
                    "You turned the flashlight off");
        } else {
            returnString = "The flashlight is out of batteries";
        }
        return returnString;
    }

    public void insertBattery(Battery battery) {
        hasBatteries = true;
        battery = null;
    }
}
