package ClassExamples;

import java.util.List;

public class AnimalBuilder {

    private String species;
    private int age;
    private List<String> favoriteFoods;

    public AnimalBuilder setAge(int age){
        this.age = age;
        return this;
    }

    public AnimalBuilder setSpecies(String species){
        this.species = species;
        return this;
    }

    public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods){
        this.favoriteFoods = favoriteFoods;
        return this;
    }

    public DesignedAnimal build(){
        return new DesignedAnimal(species, age, favoriteFoods);
    }


}
