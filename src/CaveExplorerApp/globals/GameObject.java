package CaveExplorerApp.globals;

/**
 * Base class to represent all objects in the game.
 */
public abstract class GameObject {
    //Unique name for the object.
    private String name;
    //A description of the object.
    private  String description;

    /**
     * Constructor
     *
     * @param name - Unique name for the object.
     * @param description - A description of the object
     */
    public  GameObject (String name, String description) {
        this.name= name;
        this.description = description;
    }

    /**
     * Gets the object's name.
     * @return - Object's name.
     */
    public String getName() {return name;}

    /**
     * Gets the object's description.
     * @return - Object's description.
     */
    public String getDescription() {return  description;}
}
