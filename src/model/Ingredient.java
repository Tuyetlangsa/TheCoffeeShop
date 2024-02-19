/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author long
 */
public class Ingredient implements Comparable<Ingredient>, Serializable  {
    private String code;
    private String name;
    private String measure;
    

    public Ingredient(String code, String name, String measure) {
        this.code = code;
        this.name = name;
        this.measure = measure;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

   

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

 
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

 
    @Override
    public String toString() {
        return "Ingredient{" + "code=" + code + ", name=" + name + '}';
    }

    @Override
    public int compareTo(Ingredient o) {
        if(this.getName().compareToIgnoreCase(o.getName())>0) {
            return 1;
        }
        else if(this.getName().compareToIgnoreCase(o.getName())<0)
            return -1;
        else return this.getCode().compareToIgnoreCase(o.getCode());
    }
}
