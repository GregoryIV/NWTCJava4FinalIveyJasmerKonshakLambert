package ClassExamples;

public class Animal implements Talk {

    private String species;
    private boolean canHop;
    private boolean canSwim;

    public boolean canHop() { return canHop;}
    public boolean canSwim() {return canSwim;}

    @Override
    public String toString(){ return species;}

    public Animal(String speciesName,
                  boolean canHop,
                  boolean canSwim){

        this.species = speciesName;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    @Override
    public void talk(Animal animal) {

    }
}
