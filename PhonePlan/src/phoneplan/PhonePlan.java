package phoneplan;

public class PhonePlan {
    public static void main(String[] args) {
        TextService t1 = new TextService("TS1", 100);
        VoiceService v1 = new VoiceService("VS1", 250);
        StreamingService s1 = new StreamingService("SS1", 500);
        
        FeaturePhoneSubscriber f1 = new FeaturePhoneSubscriber("FPh-1");
        FeaturePhoneSubscriber f2 = new FeaturePhoneSubscriber("FPh-2");
        SmartPhoneSubscriber sm1 = new SmartPhoneSubscriber("SmPh-1");
        
        t1.addObserver(f1);
        t1.addObserver(f2);
        t1.addObserver(sm1);
        
        v1.addObserver(f1);
        v1.addObserver(sm1);
        
        s1.addObserver(f2);
        s1.addObserver(sm1);
        
        f1.getSubCost();
        f2.getSubCost();
        sm1.getSubCost();
        
        t1.setCost(50);
        
        f1.getSubCost();
        f2.getSubCost();
        sm1.getSubCost();
        
        s1.setCost(400);
        
        f1.getSubCost();
        f2.getSubCost();
        sm1.getSubCost();
    }
    
}
