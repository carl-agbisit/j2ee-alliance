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
public class Hero implements SkillList{
    //Has multiple skills
    //Multiple instances
    private static final int SkillNum = 4;
    private String type;
    private Skill skls[] = new Skill[SkillNum];
    protected Hero(String type){
        this.type = type;
        skillInit(type);
    }
    
    protected void attack(int i){
        System.out.println(this.type + " attacks with " + skls[i].getSklName());
    }
    
    protected void block(int i){
        System.out.println(this.type + " blocks using " + skls[i].getSklName());
    }
    
    protected String getType(){
        return type;
    }
    
    protected Skill getSkill(int i){
        return skls[i];
    }
    
    @Override
    public final void skillInit(String type){
        int i;
        String nameList[] = null;
        String descList[] = null;
        switch(type){
            case "INT":
                nameList = SkillList.intList; break;
            case "AGI":
                nameList = SkillList.agiList; break;
            case "STR":
                nameList = SkillList.strList; break;
            case "DEX":
                nameList = SkillList.dexList; break;
            case "LUK":
                nameList = SkillList.lukList; break;
            default:; break;
        }
        
        for(i = 0; i < SkillNum; i++){
            skls[i] = new Skill(nameList[i]);
        }
    }
}
