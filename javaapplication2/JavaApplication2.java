/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import sun.management.jmxremote.ConnectorBootstrap;

/**
 *
 * @author asi
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    private static final int HeroNum = 5;
    public static Hero heros[] = new Hero[HeroNum];
    public static String types[] = {"INT", "AGI", "STR", "DEX", "LUK"};
    
    public static void main(String[] args) {
        initialize();
        Hero x = selHero(2);
        x.attack(3);
        Hero y = selHero(4);
        y.block(0);
        Hero z = selHero(0);
        z.attack(2);
    }
    
    public static Hero selHero(int i){
        System.out.println("Choosing " + heros[i].getType() + " Hero");
        return heros[i];
    }
    
    public static void initialize(){
        for(int i = 0; i < HeroNum; i++){
            heros[i] = new Hero(types[i]);
        }
    }
    
}
