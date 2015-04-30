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
public class Skill {
    //Can be used to attack or block
    private String sklName;
    private String sklDesc;
    protected Skill(String sklName, String sklDesc){
        this.sklName = sklName;
        this.sklDesc = sklDesc;
    }
    protected Skill(String sklName){
        this.sklName = sklName;
    }
    
    protected String getSklName(){
        return sklName;
    }
    
    protected String getSklDesc(){
        return sklDesc;
    }
    
    protected void setSklName(String nSklName){
        this.sklName = nSklName;
    }
    
    protected void setSklDesc(String nSklDesc){
        this.sklDesc = nSklDesc;
    }
}
