/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author long
 */
public class Drink implements Serializable, Comparable<Drink> {
    private String code;
    private String name;
    private int price;
    private HashMap<Ingredient, Integer> recipe;

    public Drink(String code, String name, int price, HashMap<Ingredient, Integer> recipe) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.recipe = recipe;
    }

    public Drink() {
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public HashMap<Ingredient, Integer> getRecipe() {
        return recipe;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecipe(HashMap<Ingredient, Integer> recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Drink{" + "code=" + code + ", name=" + name + ", recipe=" + recipe + '}';
    }

    @Override
    public int compareTo(Drink o) {
        if(this.getName().compareToIgnoreCase(o.getName())>0) {
            return 1;
        }
        else if(this.getName().compareToIgnoreCase(o.getName())<0)
            return -1;
        else return this.getCode().compareToIgnoreCase(o.getCode());
    }
    

}
