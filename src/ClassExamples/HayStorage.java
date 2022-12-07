package ClassExamples;

public class HayStorage {

    private int quantity = 0;
    // Private Object of itself
    private HayStorage() {};

   private static final HayStorage instance = new HayStorage();

   public static HayStorage getInstance(){
       return instance;
   }

    public synchronized void addHay(int amount){
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount){
        if(quantity > amount){
            quantity -= amount;
            return true;
        }else{
            return false;
        }
    }

    public synchronized int getHayQuanitity(){
        return quantity;
    }
}
