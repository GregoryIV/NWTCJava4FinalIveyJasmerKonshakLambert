package CaveExplorer;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Game {

    private ArrayList<Room> map;
    private Player player;

    public Game() {
        //Create map
        map = new ArrayList<Room>();

        //Create Items
        Item dynamite = new Item("dynamite","Useful for blowing stuff up");
        Item pickaxe = new Item("pickaxe","Useful for mining");
        Item flashlight = new Item("flashlight", "Really lights up the room");

        //Create Rooms
        Room caveEntrance = new Room("A bleak cave","Cave Entrance");
        Room caveRoom2 = new Room("dark cave","Cave room 2");
        Room caveRoom3 = new Room("damp cave","Cave room 3");
        Room caveRoom4 = new Room("cave cave", "Cave room 4");
        Room caveRoom5 = new Room("cave description", "Cave room 5");

        //Create Room Items
        ArrayList<Item> caveEntranceItems = new ArrayList<Item>();
        ArrayList<Item> caveRoom2Items = new ArrayList<Item>();
        ArrayList<Item> caveRoom3Items = new ArrayList<Item>();
        ArrayList<Item> caveRoom4Items = new ArrayList<Item>();
        ArrayList<Item> caveRoom5Items = new ArrayList<Item>();

        caveEntranceItems.add(pickaxe);
        caveRoom5Items.add(dynamite);

        //Map out rooms and initialize items
        caveEntrance.initializeRoom(null,null,caveRoom2,null,caveEntranceItems);
        caveRoom2.initializeRoom(caveRoom3,null,null,caveEntrance,caveRoom2Items);
        caveRoom3.initializeRoom(caveRoom5,caveRoom2,caveRoom4,null,caveRoom3Items);
        caveRoom4.initializeRoom(null,null,null,caveRoom3,caveRoom4Items);
        caveRoom5.initializeRoom(null,caveRoom3,null,null,caveRoom5Items);

        map.add(caveEntrance);
        map.add(caveRoom2);
        map.add(caveRoom3);
        map.add(caveRoom4);
        map.add(caveRoom5);

        //Create Player
        ArrayList<Item> playerInventory = new ArrayList<>();
        playerInventory.add(flashlight);
        player = new Player("Adventurer1","A bold cave diver.", caveEntrance, playerInventory);
    }

    //Displays the game's introduction based on time and locale
    public void showIntro (LocalTime time, Locale locale) {
        String introMessage = "";
        ResourceBundle rb = ResourceBundle.getBundle("CaveExplorer", locale);

        if (time.isAfter(Times.earlyMorningBeg) && time.isBefore(Times.earlyMorningEnd)) {
            introMessage = rb.getString("intro_early_morning");
        } else if (time.isAfter(Times.morningBeg) && time.isBefore(Times.morningEnd)) {
            introMessage = rb.getString("intro_morning");
        } else if (time.isAfter(Times.noonBeg) && time.isBefore(Times.noonEnd)) {
            introMessage = rb.getString("intro_noon");
        } else if (time.isAfter(Times.afternoonBeg) && time.isBefore(Times.afternoonEnd)) {
            introMessage = rb.getString("intro_afternoon");
        } else if (time.isAfter(Times.eveningBeg) && time.isBefore(Times.eveningEnd)) {
            introMessage = rb.getString("intro_evening");
        }

        System.out.println(introMessage);
    }

    public String look(GameObject gameObject) {
        return "";
    }
}
