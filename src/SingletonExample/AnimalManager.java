package SingletonExample;

import java.util.List;

public class AnimalManager {
    private final List<String> favoriteFoods;

    public AnimalManager(List<String> favoriteFoods){
        // Null check
        if(favoriteFoods == null){
            throw new RuntimeException("Favorite Foods are required");
        }

        this.favoriteFoods = favoriteFoods;
    }

    public List<String> getFavoriteFoods(){
        return favoriteFoods;
    }
}
