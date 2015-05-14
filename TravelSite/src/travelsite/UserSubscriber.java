package travelsite;

import java.util.Observable;

public class UserSubscriber extends Subscriber{
    String name;

    public UserSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.print("USub Name: " + name + "; ");
        System.out.println("Message: " + arg.toString());
    }
    
}
