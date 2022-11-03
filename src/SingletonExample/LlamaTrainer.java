package SingletonExample;

public class LlamaTrainer {

    private static final int foodAmount = 5;

    public static boolean feedLlamas(int numberToFeed){

        int amountNeeded = foodAmount * numberToFeed;

        HayStorage hayStorage = HayStorage.getInstance();

        if( hayStorage.getHayQuanitity() < amountNeeded){
            System.out.println("Low on Hay, Adding Hay");
            hayStorage.addHay(10);
        }

        boolean fed = hayStorage.removeHay(amountNeeded);

        if(fed){
            System.out.println("Llamas have been fed");
        }

        return fed;
    }

    public static void main(String[] args){

        System.out.println(LlamaTrainer.feedLlamas(5));
    }
}
