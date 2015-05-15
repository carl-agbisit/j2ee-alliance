package phoneplan;

import java.util.Observable;
import java.util.Observer;

public abstract class Subscriber implements Observer{
    @Override
    public abstract void update(Observable o, Object arg);
}
