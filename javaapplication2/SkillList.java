/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author asi
 */
public interface SkillList {
    String intList[] = {"Fire", "Ice", "Earthquake", "Lightning"};
    String intDesc[] = {};
    
    String agiList[] = {"Dash", "Side-Kick", "Backstep", "Blinkstab"};
    String agiDesc[] = {};
    
    String strList[] = {"Punch", "Stomp", "Charge", "Headbutt"};
    String strDesc[] = {};
    
    String dexList[] = {"Double Strafe", "Arrow Shower", "Charge Arrow", "Global Shot"};
    String dexDesc[] = {};
    
    String lukList[] = {"Taunt", "Deceive", "Hide", "Lucky Break"};
    String lukDesc[] = {};
    
    abstract void skillInit(String type);
}
