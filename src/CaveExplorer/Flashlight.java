package CaveExplorer;

public class Flashlight extends Item implements Useable{

    private boolean isOn;
    private boolean hasBatteries;

    public Flashlight(String name, String description, Boolean isOn, boolean hasBatteries) {
        super(name, description);
        this.isOn = isOn;
        this.hasBatteries = hasBatteries;
    }

    @Override
    public String Use() {
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
}
