package CaveExplorerApp;

import CaveExplorerApp.globals.Direction;
import CaveExplorerApp.globals.Times;
import CaveExplorerApp.items.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Game class stores and manipulates all information about the game.
 * The game is a single player, first person, escape room.
 * The players main goal is to reach the exit(Room).
 * There will be various puzzles the player will have to solve in order to reach the exit.
 */
public class Game {

    //1.1 proper use of visibility modifier
    //Map of all the rooms in the game
    private ArrayList<Room> map;

    //1.7 Use of nested class
    //Player in the game. Played in the first person.
    private Player player;

    //Tells if the game should continue running
    private boolean continueGame = true;

    /**
     * Game constructor instantiates all the game objects
     */
    public Game() {

        //Create map
        map = new ArrayList<Room>();


        //Create Rooms
        Room caveEntrance = new Room.RoomBuilder("A bleak cave","Cave Entrance").build();
        Room caveRoom2 = new Room.RoomBuilder("dark cave","Cave room 2").build();
        Room caveRoom3 = new Room.RoomBuilder("damp cave","Cave room 3").build();
        Room caveRoom4 = new Room.RoomBuilder("cave cave", "Cave room 4").build();
        Room caveRoom5 = new Room.RoomBuilder("cave description", "Cave room 5").build();
        Room caveExit = new Room.RoomBuilder("To exit the cave", "Cave Exit")
                                .setIsGameExit(true)
                                .setLockedStatus("Exit is blocked by rocks.")
                                .setIsLocked(true)
                                .build();

        //Create Items
        Dynamite dynamite = new Dynamite("dynamite","Useful for blowing stuff up", true, caveExit);
        Pickaxe pickaxe = new Pickaxe("pickaxe","Useful for mining", false);
        Flashlight flashlight = new Flashlight("flashlight", "Really lights up the room", false, false, false);
        Battery battery = new Battery("battery", "Shockingly good to have.", true);
        Flint flint = new Flint("flint", "Useful to start things on fire", true);

        //Create Room Inventories
        Inventory caveEntranceInventory = new Inventory();
        Inventory caveRoom2Inventory = new Inventory();
        Inventory caveRoom3Inventory = new Inventory();
        Inventory caveRoom4Inventory = new Inventory();
        Inventory caveRoom5Inventory = new Inventory();

        //Add items to inventories
        caveEntranceInventory.add(pickaxe);
        caveRoom5Inventory.add(dynamite);

        //Map out rooms and initialize inventories
        caveEntrance.initializeRoom(null,null,caveRoom2,caveExit,caveEntranceInventory);
        caveRoom2.initializeRoom(caveRoom3,null,null,caveEntrance,caveRoom2Inventory);
        caveRoom3.initializeRoom(caveRoom5,caveRoom2,caveRoom4,null,caveRoom3Inventory);
        caveRoom4.initializeRoom(null,null,null,caveRoom3,caveRoom4Inventory);
        caveRoom5.initializeRoom(null,caveRoom3,null,null,caveRoom5Inventory);
        caveExit.initializeRoom(null,null,caveEntrance,null,null);

        //Add rooms to the map
        map.add(caveEntrance);
        map.add(caveRoom2);
        map.add(caveRoom3);
        map.add(caveRoom4);
        map.add(caveRoom5);
        map.add(caveExit);

        //Create Player
        Inventory playerInventory = new Inventory();
        playerInventory.add(flashlight);
        playerInventory.add(battery);
        playerInventory.add(flint);
        playerInventory.add(dynamite);
        player = new Player("Adventurer1","A bold cave diver.", caveEntrance, playerInventory);

    }

    /**
     * Displays the game's introduction based on time and locale
     * 5.1 Use of dates and times in your application.
     * 5.3 Proper use of String localization.
     * @param time - Time that the game is being played
     * @param locale - language the game is being played in
     */
    public void showIntro (LocalTime time, Locale locale) {
        String introMessage = "";
        ResourceBundle rb = ResourceBundle.getBundle("CaveExplorerApp", locale);

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

    /**
     * Tries to move the player in a given direction.
     * Fails to move if there is no exit in the given direction.
     *
     * @param directionToMove - Direction to move the player.
     * @return - Details about the moves
     */
    public String MovePlayer(Direction directionToMove) {
        String userMessage;

        userMessage = player.move(directionToMove);

        if (player.getCurrentRoom().isGameExit()) {
            continueGame = false;
            return "You win";
        }

        return userMessage;
    }

    /**
     * Gets the players current inventory
     *
     * @return Players inventory
     */
    public String ShowPlayerInventory() {return player.printInventory();}

    /**
     * Gets a description of the players current room
     * 2.2 valid use of encapsulation
     *
     * @return - Description of players current room
     */
    public String playerLook() {return player.look();}

    /**
     * Gets a description of a game object from the perspective of the player.
     * Game object must be visible to the player (in room or on player).
     *
     * @param gameObject - Game object the player is attempting to look at.
     * @return - Description of the object if it exists and is within the players view.
     *           Message to the user if the object can't be seen (object not in room or doesn't exist).
     */
    public String playerLookAt(String gameObject) {return player.lookAt(gameObject);}

    /**
     * Player tries to take an item from their current room.
     *
     * @param itemName - Name of the item that the player is trying to take.
     * @return Message to the user if the players was successful or unsuccessful in taking the item.
     */
    public String playerTakeItem(String itemName) {return player.takeItem(itemName);}

    /**
     * Players tries to use an item.
     *
     * @param itemName - Name of the item the players is trying to use.
     * @return - Message to the user whether the item was used.
     */
    public String playerUseItem(String itemName) {return player.useItem(itemName);}

    /**
     * Player tries to drop an item.
     *
     * @param itemName - Name of the item the player is trying to drop.
     * @return - Message to the user whether the item was dropped.
     */
    public String playerDropItem(String itemName) {return player.dropItem(itemName);}

    /**
     * Player tries to use and item on another item.
     *
     * @param nameOfItemToUse - Name of the item that is trying to be used.
     * @param nameOfItemToUseOn - Name of the item that will be used on.
     * @return - Message to the user if the method was successful or not.
     */
    public String playerUseItemOn(String nameOfItemToUse, String nameOfItemToUseOn) {return player.useItemOn(nameOfItemToUse,nameOfItemToUseOn);}

    /**
     * Gets the players inventory.
     *
     * @return - Players inventory.
     */
    public Inventory getPlayerInventory() {return player.getInventory();}

    /**
     * Gets the player's current room.
     *
     * @return Player's current room.
     */
    public Room getPlayerRoom (){return player.getCurrentRoom();}

    /**
     *  Gets continue game status.
     *
     * @return - Continue game.
     */
    public Boolean getContinueGame() {return continueGame;}

}
