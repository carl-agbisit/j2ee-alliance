package travelsite;

import java.util.Observable;

public class SystemSubscriber extends Subscriber{
    String name;

    public SystemSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.print("SSub Name: " + name + "; ");
        System.out.println("Message: " + arg);
    }
    
}
