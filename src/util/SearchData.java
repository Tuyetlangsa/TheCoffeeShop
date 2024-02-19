package util;

import java.util.Map.Entry;
import model.Drink;
import model.Drink_Menu;

import model.Ingredient;
import model.TheIngredientWareHouse;

public class SearchData {
    public static boolean searchIngredientByID(TheIngredientWareHouse hm, String id ) {
        for (Ingredient ingr :
             hm.keySet()) {
                if(ingr.getCode().equalsIgnoreCase(id)) return true;
             }
        return false;
    }
    public static Ingredient searchIngredientByIDV2( TheIngredientWareHouse hm, String id) {
        Ingredient find = null;
        for(Ingredient ingr: hm.keySet()) {
            if(ingr.getCode().equalsIgnoreCase(id)) find = ingr;
        }
        return find;
    }
    
    public static boolean searchDrinkByID(String id, Drink_Menu mn) {
        for (Drink drink : mn) {
            if(drink.getCode().equalsIgnoreCase(id)) return true;
        }
        return false;
    }
    
    public static Drink searchDrinkByIDV2(String id, Drink_Menu mn) {
        for (Drink drink : mn) {
            if(drink.getCode().equalsIgnoreCase(id)) return drink;
        }
        return null;
    }
    
    
}
