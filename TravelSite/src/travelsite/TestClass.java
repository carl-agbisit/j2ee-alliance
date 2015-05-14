package travelsite;

public class TestClass {
    public static void main(String[] args) {
        PromoPublisher pp = new PromoPublisher("Pub1");
        UserSubscriber x = new UserSubscriber("s1");
        UserSubscriber y = new UserSubscriber("x0");
        SystemSubscriber z = new SystemSubscriber("Blankard");
        
        pp.addObserver(x);
        pp.addObserver(y);
        pp.addObserver(z);
        
        System.out.println("Travel Site Current Message: " + pp.getNews());
        pp.setNews("New Promo A");
        System.out.println("---------------------------------------");
        pp.deleteObserver(y);
        pp.setNews("Promo A Expired");
        System.out.println("Travel Site Current State: " + pp.getNews());
    }
}
