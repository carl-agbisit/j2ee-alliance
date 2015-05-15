package phoneplan;

import java.util.ArrayList;
import java.util.Observer;

public class TextService extends Service{
    ArrayList<Subscriber> subscribers = new ArrayList<>();
    String name;
    int cost;

    public TextService(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        System.out.println("TextService " + getName() + "'s cost changed from " + getCost() + " to " + cost);
        notifyObservers(cost);
        this.cost = cost;
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized void deleteObservers() {
        for(Subscriber sub : subscribers){
            sub.update(this, -getCost());
        }
        subscribers.clear();
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        boolean remove = subscribers.remove((Subscriber) o);
        o.update(this, -getCost());
    }

    @Override
    public synchronized void addObserver(Observer o) {
        subscribers.add((Subscriber) o);
        o.update(this, getCost());
    }

    @Override
    public void notifyObservers() {
        for(Subscriber sub : subscribers){
            sub.update(this, cost);
        }
    }

    @Override
    public void notifyObservers(Object arg) {
        int x = getCost() * -1;
        for(Subscriber sub : subscribers){
            sub.update(this, x);
        }
    }
    
}
