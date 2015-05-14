package travelsite;

import java.util.ArrayList;
import java.util.Observer;

public class PromoPublisher extends Publisher{
    ArrayList<Subscriber> subscribers = new ArrayList<>();
    String name, news;

    public PromoPublisher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
        this.news = this.news.concat(" from " + getName());
        notifyObservers();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        subscribers.add((Subscriber) o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        boolean remove = subscribers.remove((Subscriber) o);
    }

    @Override
    public synchronized void deleteObservers() {
        subscribers.clear();
        System.out.println("Subscribers cleared!");
    }

    @Override
    public void notifyObservers() {
        for(Subscriber sub : subscribers){
            sub.update(this, getNews());
        }
    }
}
