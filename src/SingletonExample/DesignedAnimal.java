package SingletonExample;

import java.util.List;

public class DesignedAnimal {
    private String species;
    private int age;
    List<String> favoriteFoods;

    public DesignedAnimal(String species, int age,
                          List<String> favoriteFoods){
        this.species = species;
        this.age = age;
        this.favoriteFoods = favoriteFoods;
    }
}
