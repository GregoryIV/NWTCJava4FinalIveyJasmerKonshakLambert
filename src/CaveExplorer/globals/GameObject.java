package CaveExplorer.globals;

public abstract class GameObject {
    private String name;
    private  String description;

    public  GameObject (String name, String description) {
        this.name= name;
        this.description = description;
    }

    public String getName() {return name;}

    public String getDescription() {return  description;}
}
