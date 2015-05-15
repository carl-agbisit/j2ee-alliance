package phoneplan;

import java.util.Observable;

public abstract class Service extends Observable{
    @Override
    public abstract void notifyObservers();
}
