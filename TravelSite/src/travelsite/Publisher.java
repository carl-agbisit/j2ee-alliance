package travelsite;

import java.util.Observable;

public abstract class Publisher extends Observable{
    boolean state = false;

    public boolean getState() {
        return state;
    }

    public void toggleState() {
        state = !state;
    }

    @Override
    public abstract void notifyObservers();
    
}
