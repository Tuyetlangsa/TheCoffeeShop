package model;

import java.io.Serializable;

import java.util.HashMap;

public class TheIngredientWareHouse extends HashMap<Ingredient, Integer> implements Serializable{

    public TheIngredientWareHouse() {
    }

    public boolean addItem(Ingredient item, Integer quantity) {
       this.put(item, quantity);
      return true;
   }

    /**
     *
     * @param ingr
     * @param name
     * @param measure
     * @param quantity
     */
    public synchronized void updateItem(Ingredient ingr, String name, String measure, int quantity) {
        ingr.setName(name);
        ingr.setMeasure(measure);
        this.replace(ingr, quantity);  
    }
    
    public  void deleteItem(Ingredient ingr) {
        this.remove(ingr);
    }
    
}
