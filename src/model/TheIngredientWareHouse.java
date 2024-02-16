package model;

import java.io.Serializable;

import java.util.HashMap;

public class TheIngredientWareHouse extends HashMap<Ingredient, Integer> implements Serializable{

    public boolean addItem(Ingredient item, Integer quantity) {
       this.put(item, quantity);
      return true;
   }

    public void updateItem(Ingredient ingr, String name, String type, int weight, String measure, int quantity) {
        ingr.setName(name);
        ingr.setUnitType(type);
        ingr.setUnitWeight(weight);
        this.replace(ingr, quantity);  
    }
    
    public  void deleteItem(Ingredient ingr) {
        this.remove(ingr);
    }
    
}
