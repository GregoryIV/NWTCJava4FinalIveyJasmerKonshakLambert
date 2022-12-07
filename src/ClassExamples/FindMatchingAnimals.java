package ClassExamples;

import java.util.function.Predicate;

public class FindMatchingAnimals {

    private static void print(Animal animal,
                              Predicate<Animal> trait){
        if(trait.test(animal)){
            System.out.println(animal + "can do it!");
        }else{
            System.out.println(animal + "Can't do it!");
        }
    }

    public static void main(String[] args){

        Animal fish = new Animal("Pleco", false, true);

        System.out.println("Checking if fish can hop!");
        print(new Animal("Fish ",
                         false, true),
              x -> x.canHop());

        print(new Animal("Bird", true, false),
                x -> x.canSwim());

    }
}
