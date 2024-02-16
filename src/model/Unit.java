/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author long
 */
public class Unit {
    private String type;
    private int weight;
    private String measure;
    
    
    public Unit() {
    }
   
    public Unit(String type, int weight,String measure) {
        this.type = type;
        this.weight = weight;
        this.measure = measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getMeasure() {
        return measure;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return  "1" + type + "= " + weight ;
    }
}
