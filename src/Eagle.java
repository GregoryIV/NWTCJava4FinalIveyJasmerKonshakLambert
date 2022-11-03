public class Eagle extends Animal implements Fly{

    private int wingSpan = 15;

    public Eagle(String speciesName, boolean canHop, boolean canSwim) {
        super(speciesName, canHop, canSwim);
    }

    @Override
    public int getWingSpan() throws Exception {
        return wingSpan;
    }

    @Override
    public void land() {
        System.out.println("Eagle is flying!");
    }

    @Override
    public void talk(Animal animal) {
        System.out.println("I am an eagle!");
    }
}
