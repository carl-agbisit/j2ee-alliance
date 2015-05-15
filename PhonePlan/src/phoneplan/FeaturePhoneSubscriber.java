package phoneplan;

import java.util.Observable;

public class FeaturePhoneSubscriber extends Subscriber{
    String name;
    int tCost;

    public FeaturePhoneSubscriber(String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }

    public int gettCost() {
        return tCost;
    }

    public void settCost(int tCost) {
        this.tCost = tCost;
    }

    @Override
    public void update(Observable o, Object arg) {
        notify((Service) o, (int) arg);
    }
    
    public void notify(Service s, int x){
        tCost += x;
    }
    
    public void getSubCost(){
        System.out.print("Phone Name: " + name + " | ");
        System.out.println("Total Cost: " + gettCost());
    }
    
}
