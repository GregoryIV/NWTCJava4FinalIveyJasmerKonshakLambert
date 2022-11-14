package CaveExplorer;

public abstract class GameObject {
    private String name;
    private  String description;

    public  GameObject (String name, String description) {
        this.name= name;
        this.description = description;
    }

    String getName() {return name;}

    String getDescription() {return  description;}
}
